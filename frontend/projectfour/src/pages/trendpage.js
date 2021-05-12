import React, { useContext, useEffect, useState } from 'react'
import { Chart } from 'react-charts'
import './trendchart.css'
import _ from 'lodash'
import { Context } from '../Context';
import axios from 'axios';

const TrendPage = () => {

  const [context, setContext] = useContext(Context);

  const [visible, setVisible] = useState(false);
  const [confirmLoading, setConfirmLoading] = useState(false);
  const [modalText, setModalText] = useState("");

  const graphdata = [{x:0,y:0},{x:1,y:3},{x:2,y:6},{x:3,y:2}]

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
          width: '1000px',
          height: '500px',
          margin: 'auto'
        }}
      >
        {graphdata.length === 0 && <p style={{textAlign:'center'}}>No symptom data can be found.</p>}
        {graphdata.length !== 0 && <> <Chart data={data} series={series} axes={axes} /> <p style={{textAlign:'center',margin:'2rem'}}>Your last day health score is 2. You are getting better.</p></>}
      </div>
    </div>
  )
}

export default TrendPage;