

export const CadastrarMedicacao = (props) => {
    const [nome, setNome] = useState("");
    const [descricao, setDescricao] = useState("");
    const [observacao, setObservacao] = useState("");
    const [intervalo, setIntervalo] = useState("");
    const [ultimaDosagem, setUltimaDosagem] = useState("");
    const [posologia, setPosologia] = useState("");

    const { loading, errorMessage } = useAuthState()

    const cadastrar = () => {
        console.log()
        const medicacoes = {
            nome: nome, descricao: descricao, observacao: observacao, intervalo: intervalo, ultimaDosagem: ultimaDosagem, posologia: posologia
        }

        console.log(medicacoes)
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(medicacao)
        };
        fetch('http://localhost:5000/api/medicacoes', requestOptions)
            .then(async response => {
                const isJson = response.headers.get('content-type')?.includes('application/json');
                const data = isJson && await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response status
                    const error = (data && data.message) || response.status;
                    console.log(error);
                    setErrorText(error);
                    return Promise.reject(error);
                }                
                props.history.push("/medicacoes")
            })
            .catch(error => {
                setErrorText(error.toString());
                console.error('There was an error!', error);
            });

    }

    const handleSubmit = (a) => {
        a.preventDefault();
        cadastrar();
    }

    return (
        <div className = 'listaMedicamento'>
            <h1>{medicacoes.nome}</h1>
            <div className= 'blocoMedicamento' name="descricao">
                <h3>Descricao</h3>
                <p>{medicacoes.descricao}</p>
            </div>
            <div className= 'blocoMedicamento' name="observacao">
                <h3>Observação</h3>
                <p>{medicacoes.observacao}</p>
            </div>
            <div className= 'blocoMedicamento' name="intervalo">
                <h3>Intervalo</h3>
                <p>{medicacoes.intervalo}</p>
            </div>
            <div className= 'blocoMedicamento' name="ultimaDosagem">
                <h3>Última Dosagem</h3>
                <p>{medicacoes.ultimaDosagem}</p>
            </div>
            <div className= 'blocoMedicamento' name="posologia">
                <h3> Posologia</h3>
                <p>{medicacoes.posologia}</p>
            </div>
        </div>

    );



};