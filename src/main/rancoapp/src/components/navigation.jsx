export const Navigation = (props) => {
  return (
    <nav>
      <div >
        {/* <img src="img/assets/Logo-upe-site.png" className="logoUPE" alt="" />{" "} */}
        <div className='navbar-header'>
          <button>
            {' '}
            <span className='sr-only'>Toggle navigation</span>{' '}
            <span className='icon-bar'></span>{' '}
            <span className='icon-bar'></span>{' '}
            <span className='icon-bar'></span>{' '}
          </button>
          <a className='navbar-brand page-scroll' href='#page-top'>
            Invocado
          </a>{' '}
        </div>

        <div
          className='collapse navbar-collapse'
          id='bs-example-navbar-collapse-1'
        >
          <ul className='nav navbar-nav navbar-right'>
            <li>
              <a href='/' className='page-scroll'>
                Inicio
              </a>
            </li>
            <li>
              <a href='/eventos' className='page-scroll'>
                Eventos
              </a>
            </li>
            <li>
              <a href='/medicações' className='page-scroll'>
                Medicações
              </a>
            </li>
            <li>
              <a href='/cadastro' className='page-scroll'>
                Cadastro
              </a>
            </li>
            <li>
              <a href='/perfil' className='page-scroll'>
                Perfil
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}
