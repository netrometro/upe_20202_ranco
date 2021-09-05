

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
            body: JSON.stringify(projeto)
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
                props.history.push("/projetos")
            })
            .catch(error => {
                setErrorText(error.toString());
                console.error('There was an error!', error);
            });

    }

    const handleSubmit = (e) => {
        e.preventDefault();
        cadastrar();
    }

    return (
        <div></div>

    );



};