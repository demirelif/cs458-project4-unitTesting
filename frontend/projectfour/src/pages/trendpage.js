import React from 'react'
import { Chart } from 'react-charts'
import './trendchart.css'
import _ from 'lodash'

const TrendPage = () => {


  const getData = () => {
    const data = {authed_user: "artun", symptom_date:[{
      date:"Thu May 13 2021 14:31:16 GMT+0300 (GMT+03:00)",
      symptoms:["red","blue"]
    },{
      date:"Sun May 09 2021 14:31:16 GMT+0300 (GMT+03:00)",
      symptoms:["red"]
    },{
      date:"Thu May 20 2021 14:31:16 GMT+0300 (GMT+03:00)",
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