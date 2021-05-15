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

  const [graphdata, setGraphdata] = useState([])
  const [responsedata,setResponsedata] = useState(null);

  const data = React.useMemo(
    () =>
      [
        {
          label: 'Your trends',
          data: (graphdata.length) < 1 ? [] : graphdata
        }
      ],
    [graphdata]
  )

  useEffect(() => {
    //async bi request at, bekle
    axios.get(`http://localhost:8080/api/patient/symptoms?email=${context.authed_email}`)
      .then((response) => {
        setResponsedata(response.data)
        setGraphdata(_.chain(response.data).orderBy((a) => new Date(a.date), ['asc']).map(a => { return { x: new Date(a.date).toDateString(), y: a.score } }).value());
      }).catch(function (error) {
        console.log(error);
      });
    //on get response
  }, []);

  const axes = React.useMemo(
    () => [
      { primary: true, type: 'ordinal', position: 'bottom' },
      { type: 'linear', position: 'left' }
    ],
    []
  )

    const HealthMessage = () => {
      if(responsedata){
          if(responsedata.length > 1){
            const scorestate = responsedata[responsedata.length - 1].score - responsedata[responsedata.length - 2].score;
            let stateofthescore,statemessage;
            if(scorestate > 0){
              stateofthescore = "getting worse";
              statemessage = "You'd better rest!";
            }else if(scorestate == 0){
              stateofthescore = "not getting better";
              statemessage = "Try to treat yourself better!";
            }else{
              stateofthescore = "getting better";
              statemessage = "Keep it up!";
            }
            return <p>Your last day score is {responsedata[responsedata.length - 1].score}. 
            <br></br> Results state that you are {stateofthescore}. {statemessage}</p>
          }else{
            return <p>Not enough data for interpretation</p>
          }
      }
    }

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
        {graphdata.length === 0 && <p style={{ textAlign: 'center' }}>No symptom data can be found.</p>}
        {graphdata.length !== 0 && <> <Chart data={data} series={series} axes={axes} /> <p style={{ textAlign: 'center', margin: '2rem' }}>
          <HealthMessage/>
      </p></>}
      </div>
    </div>
  )
}

export default TrendPage;