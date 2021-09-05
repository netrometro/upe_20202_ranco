import { logout, useAuthDispatch, useAuthState } from "../context";

export const Navigation = (props) => {
  const state = useAuthState();
  const dispatch = useAuthDispatch()
  console.log(state)

  const handleLogout = () => {
    logout(dispatch)
    window.location.href = '/'
  }
  return (
    <nav className='navbar'>
      <div className='navegacao'>
        <div className='navbar-header'>
          <a className='tittle' href='/'>
            Invocado
          </a>{' '}
        </div>

        <div className='paginas'>
          {
            state.userDetails
              ?
              <li>
                <a href='/eventos' className='page'>
                  Eventos
                </a>
              </li>
              : <></>
          }
          {
            state.userDetails
              ?
              <li>
                <a href='/medicacoes' className='page'>
                  Medicações
                </a>
              </li>

              : <></>
          }

          
          {
            !state.userDetails
              ?
              <li>
                <a href='/cadastro' className='page'>
                  Cadastro
                </a>
              </li>

              : <></>
          }
          {
            state.userDetails
              ?
              <li>
                <a href='/perfil' className='page'>
                  Perfil
                </a>
              </li>

              : <></>
          }
          {
            state.userDetails
              ?
              <li>
                <button id='sairButton' onClick={handleLogout} className='page'>
                  Sair
                </button>
              </li>

              : <></>
          }
        </div>
      </div>
    </nav>
  )
}
