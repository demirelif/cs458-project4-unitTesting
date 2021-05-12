import React,{useContext, useState} from 'react'
import { Chart } from 'react-charts'
import './trendchart.css'
import _ from 'lodash'
import { Context } from '../Context';


const TrendPage = () => {

  const [context, setContext] = useContext(Context);
    
  const [visible, setVisible] = useState(false);
  const [confirmLoading, setConfirmLoading] = useState(false);
  const [modalText, setModalText] = useState("");

  const getData = () => {
    const data = {authed_user: "artun", symptom_date:[{
      date:"Tue May 18 2021",
      symptoms:["red","blue"]
    },{
      date:"Wed May 19 2021",
      symptoms:["red"]
    },{
      date:"Mon May 17 2021",
      symptoms:["red","blue","green"]
    }]}

    const symptoms_and_date = data.symptom_date;
    console.log(_.chain(symptoms_and_date).orderBy((a) => new Date(a.date), ['asc']).map( a => {return { x:new Date(a.date).toDateString(), y: a.symptoms.length}}).value())
    return _.chain(symptoms_and_date).orderBy((a) => new Date(a.date), ['asc']).map( a => {return { x:new Date(a.date).toDateString(), y: a.symptoms.length}}).value() // or 'desc']
  }
  const data = React.useMemo(
    () => [
      {
        label: 'Your trends',
        data: getData()
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
        <Chart data={data} series={series} axes={axes} />
      </div>
    </div>
  )
}

export default TrendPage;