export const Navigation = (props) => {
  return (
    <nav className='navbar'>
      <div className='navegacao'>
        <div className='navbar-header'>
          <a className='tittle' href='/'>
            Invocado
          </a>{' '}
        </div>

        <div className='paginas'>
            <li>
              <a href='/eventos' className='page'>
                Eventos
              </a>
            </li>
            <li>
              <a href='/medicações' className='page'>
                Medicações
              </a>
            </li>
            <li>
              <a href='/cadastro' className='page'>
                Cadastro
              </a>
            </li>
            <li>
              <a href='/perfil' className='page'>
                Perfil
              </a>
            </li>
            
        </div>
      </div>
    </nav>
  )
}
