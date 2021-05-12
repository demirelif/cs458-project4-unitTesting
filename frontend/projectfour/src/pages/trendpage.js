import React from 'react'
import { Chart } from 'react-charts'
 
const TrendPage = () => {
  const data = React.useMemo(
    () => [
      {
        label: 'Your trends',
        data: [{ x: "12.43", y: 1 }, { x: 2, y: 5 }, { x: 3, y: 10 }]
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
      <div>
      <p>SDsaasd</p>
    // A react-chart hyper-responsively and continuously fills the available
    // space of its parent element automatically
    <div
      style={{
        width: '400px',
        height: '300px'
      }}
    >
      <Chart data={data} series={series} axes={axes} />
    </div>
    </div>
  )
}

export default TrendPage;