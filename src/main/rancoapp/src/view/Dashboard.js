import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/lista.css"
import { Link } from "react-router-dom";
import { useAuthDispatch, useAuthState } from "../context";
import { Pie } from 'react-chartjs-2'


export default () => {
    useEffect(() => {
        getEventos();
    }, [])
    const state = useAuthState();
    const dispatch = useAuthDispatch()

    const [status, setStatus] = useState([]);
    const [categoria, setCategoria] = useState([]);
    const [motivo, setMotivo] = useState([]);

    const getEventos = () => {
        fetch('http://localhost:5000/dados/52')
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setStatus(data.status);
                setCategoria(data.categoria);
                setMotivo(data.motivo);
            })
    }

    

    if (state.userDetails) {

        return (
            <div>
<<<<<<< HEAD
                {/* <div className='listaEvento'>
                    <h1 id='eventos'>Dashboard</h1>
                    <a href='/adicionarEvento'>Adicionar Evento</a>
                    {eventos.map((evento) => (
                        <Link to={`/eventos/${evento.id}`} key={evento.id}>
                            <div className='blocoEvento'>
                                <h3>{evento.titulo}</h3>
                                <h3>Categoria : {evento.categoria}</h3>
                                {/* se o status for false bloco vermelho, se for true, verde */}
                          {/*   </div>
                        </Link>
                    ))}

                </div> */}

                <canvas>
                    
                </canvas>
=======
                <div className='listaEvento'>
                <Pie
        data={{
          labels: ['Status', 'Categoria', 'Motivo'],
          datasets: [
            {
              label: '# of votes',
              data: [12, 19, 3,],
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
              ],
              borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',

              ],
              borderWidth: 1,
            },

          ],
        }}
        height={400}
        width={600}
        options={{
          maintainAspectRatio: false,
          scales: {
            yAxes: [
              {
                ticks: {
                  beginAtZero: true,
                },
              },
            ],
          },
          legend: {
            labels: {
              fontSize: 25,
            },
          },
        }}
      />
    </div>

               
>>>>>>> dashboard

            </div>
        )
    }
    else{
        window.location.href = '/login';
    }
}
