import { useNavigate } from "react-router-dom"
const HeaderComponent = () => {
    const navigator = useNavigate();
    function toSignIn() {
        navigator("/sing-in")
    }
    return (
        <div>
                <header>
                        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                                <a className="navbar-brand ml-5" href="/">Bottle Drive</a>
                                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                        <span className="navbar-toggler-icon"></span>
                                </button>
                                <div className="collapse navbar-collapse" id="navbarNav">
                                        <ul className="navbar-nav ml-auto">
                                                <li className="nav-item">
                                                        <a className="nav-link" href="/">Home</a>
                                                </li>
                                                <li className="nav-item">
                                                        <a className="nav-link" href="/about">About</a>
                                                </li>
                                                <li className="nav-item">
                                                        <a className="nav-link" href="/contact">Contact</a>
                                                </li>
                                        </ul>
                                </div>
                                <div className="ml-auto mr-3">
                                        <button className="btn btn-primary" type="button" onClick={toSignIn}>Sign In</button>
                                </div>
                        </nav>
                </header>
        </div>
    )
}

export default HeaderComponent