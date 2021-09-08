import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/dashboard.css"
import { Link } from "react-router-dom";
import { useAuthDispatch, useAuthState } from "../context";
import { Pie } from 'react-chartjs-2'


export default () => {
    useEffect(() => {
        getEventos();
        getDados();
        getMedicacao();
    }, [])
    const state = useAuthState();
    const dispatch = useAuthDispatch()

    const [status, setStatus] = useState([]);
    const [categoria, setCategoria] = useState([]);
    const [motivo, setMotivo] = useState([]);
    const [eventos, setEventos] = useState([]);
    const [medicacoes, setMedicacao] = useState([]);
    const getMedicacao = () => {
        fetch(`http://localhost:5000/medicacoes/${JSON.parse(state.userDetails).id}`)
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setMedicacao(data.medicacoes.slice(0, 5));
            })
    }

    const getEventos = () => {
        fetch(`http://localhost:5000/eventos/${JSON.parse(state.userDetails).id}`)
            .then(async response => {
                const data = await response.json();
                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setEventos(data.eventos.slice(0, 3));
            })
    }

    const getDados = () => {
        fetch('http://localhost:5000/dados/' + JSON.parse(state.userDetails).id)
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



    /* categoria */
    var qtdTrabalho = categoria.filter(x => x === 'TRABALHO').length
    var qtdAmigos = categoria.filter(x => x === 'AMIGOS').length
    var qtdDesconhecidos = categoria.filter(x => x === 'DESCONHECIDOS').length
    var qtdEscola = categoria.filter(x => x === 'ESCOLA').length
    var qtdFaculdade = categoria.filter(x => x === 'FACULDADE').length
    var qtdFamilia = categoria.filter(x => x === 'FAMILIA').length

    /*  status */
    var qtdTrue = status.filter(x => x === true).length
    var qtdFalse = status.filter(x => x === false).length

    /* motivo */
    var qtdCulpa = motivo.filter(x => x === 'CULPA').length
    var qtdMedo = motivo.filter(x => x === 'MEDO').length
    var qtdTimidez = motivo.filter(x => x === 'TIMIDEZ').length
    var qtdTristeza = motivo.filter(x => x === 'TRISTEZA').length
    var qtdVergonha = motivo.filter(x => x === 'VERGONHA').length



    if (state.userDetails) {
        return (
            <div className='centralizado'>
                <div className='listaEvento'>
                    <div className='header'>
                        <h1>DashBoard</h1>
                    </div>
                    <div className='legendas'>
                        <legend>Evento status</legend>
                        <legend>Evento Motivo</legend>
                        <legend>Evento Categoria</legend>
                    </div>
                    <div className='graficos'>
                        <div className='grafico'>
                            <Pie
                                data={{
                                    labels: ['Ativos', 'Fechados'],
                                    datasets: [
                                        {
                                            label: 'Status',
                                            data: [qtdTrue, qtdFalse],
                                            backgroundColor: [
                                                'rgba(54, 162, 235, 1)',
                                                'rgba(255, 99, 132, 1)',


                                            ],
                                            borderColor: [
                                                'rgba(255, 255, 255, 1)',

                                            ],
                                            borderWidth: 1,
                                        },

                                    ],
                                }}
                                height={200}
                                width={300}
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
                                            fontSize: 15,
                                        },
                                    },
                                }}
                            />
                        </div>

                        <div className='grafico'>

                            <Pie
                                data={{
                                    labels: ['Culpa', 'Medo', 'Timidez', 'Tristeza', 'Vergonha'],
                                    datasets: [
                                        {
                                            label: 'Motivos',
                                            data: [qtdCulpa, qtdMedo, qtdTimidez, qtdTristeza, qtdVergonha],
                                            backgroundColor: [
                                                'rgba(255, 99, 132, 1)',
                                                'rgba(54, 162, 235, 1)',
                                                'rgba(255, 206, 86, 1)',
                                                'rgba(75, 192, 192, 1)',
                                                'rgba(153, 102, 255, 1)',
                                                'rgba(255, 159, 64, 1)',
                                            ],
                                            borderColor: [
                                                'rgba(255, 255, 255, 1)',

                                            ],
                                            borderWidth: 1,
                                        },

                                    ],
                                }}
                                height={200}
                                width={300}
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
                                            fontSize: 15,
                                        },
                                    },
                                }}
                            />

                        </div>
                        <div className='grafico' >

                            <Pie
                                data={{
                                    labels: ['Trabalho', 'Amigos', 'Desconhecidos', 'Escola', 'Faculdade', 'Familia'],
                                    datasets: [
                                        {
                                            label: 'Categorias',
                                            data: [qtdTrabalho, qtdAmigos, qtdDesconhecidos, qtdEscola, qtdFaculdade, qtdFamilia],
                                            backgroundColor: [
                                                'rgba(255, 99, 132, 1)',
                                                'rgba(54, 162, 235, 1)',
                                                'rgba(255, 206, 86, 1)',
                                                'rgba(75, 192, 192, 1)',
                                                'rgba(153, 102, 255, 1)',
                                                'rgba(255, 159, 64, 1)',
                                            ],
                                            borderColor: [
                                                'rgba(255, 255, 255, 1)',
                                            ],
                                            borderWidth: 1,
                                        },

                                    ],
                                }}
                                height={200}
                                width={300}
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
                                            fontSize: 15,
                                        },
                                    },
                                }}
                            />
                        </div>
                    </div>
                    <div id='listas'>


                        <div className='header'>
                            <h1 id='eventos'>Meus Eventos</h1>
                        </div>
                        <div className='listaEvento' id='dashboard'>
                            {eventos.map((evento, i) => (
                                <Link to={`/eventos/${evento.id}`} key={evento.id}>
                                    <div className='blocoEvento'>
                                        <div className='header'>
                                            <h3>{evento.titulo}</h3>
                                            <div className='blocoEvento' name="status" id={evento.status ? 'statusTRUE' : 'statusFALSE'}>
                                            </div>
                                        </div>
                                        <h3>Categoria : {evento.categoria}</h3>
                                        {/* se o status for false bloco vermelho, se for true, verde */}
                                    </div>
                                </Link>
                            ))}
                        </div>
                        <div className='header'>
                            <h1 id='eventos'>Minhas Medicações</h1>
                        </div>
                        <div className="listaEvento" id='dashboard'>
                            {medicacoes.map((medicacao) => (
                                <Link to={`/medicacoes/${medicacao.id}`} key={medicacao.id}>
                                    <div className="blocoEvento">
                                        <h3>{medicacao.nome}</h3>
                                        <h3>Intervalo: {medicacao.intervalo}</h3>
                                    </div>
                                </Link>
                            ))}
                        </div>
                    </div>

                </div>

            </div>
        )
    }
    else {
        window.location.href = '/login';
    }
}
