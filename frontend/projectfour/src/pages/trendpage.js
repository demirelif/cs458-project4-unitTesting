import React, { useContext, useEffect, useState } from 'react'
import { Chart } from 'react-charts'
import './trendchart.css'
import _ from 'lodash'
import { Context } from '../Context';
import axios from 'axios';

const TrendPage = () => {

  const [context, setContext] = useContext(Context);

  const [graphdata, setgraphdata] = useState([])

  const [visible, setVisible] = useState(false);
  const [confirmLoading, setConfirmLoading] = useState(false);
  const [modalText, setModalText] = useState("");

  useEffect(() => {
    axios.get(`http://localhost:8080/api/symptoms?email=${context.authed_email}`).then(response => {
      setgraphdata( _.chain(response.data).orderBy((a) => new Date(a.date), ['asc']).map(a => { return { x: new Date(a.date).toDateString(), y: a.symptoms.length } }).value());
    }).catch((e) => {
      console.log(e);
    })
  })

  const data = React.useMemo(
    () => [
      {
        label: 'Your trends',
        data: graphdata
      }
    ],
    []
  )

  const axes = React.useMemo(
    () => [
      { primary: true, type: 'ordinal', position: 'bottom' },
      { type: 'linear', position: 'left' }
    ],
    []
  )

  const series = React.useMemo(
    () => ({
      type: 'bar'
    }),
    []
  )

  return (
    <div className="trend-chart">
      <div
        style={{
          width: '400px',
          height: '300px',
          margin: 'auto'
        }}
      >
        {graphdata.length === 0 && <p style={{textAlign:'center'}}>No symptom data can be found.</p>}
        {graphdata.length !== 0 && <> <Chart data={data} series={series} axes={axes} /> <p style={{textAlign:'center',margin:'2rem'}}>Your last day health score is {graphdata[graphdata.length - 1].score}</p></>}
      </div>
    </div>
  )
}

export default TrendPage;