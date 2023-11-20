import {useState} from "react"
export function Login({setUser}) {
    const [nombre, setNombre] = useState("")
    const [contraseña, setContraseña] = useState("")
    const [error, setError] = useState(false)

    const handleSubmit = (e) =>{
        e.preventDefault()

        if(nombre == "" || contraseña == ""){
            setError(true)
            return
        }

        setError(false)
        setUser([nombre])
    }
    return(
        <section>
            <h1>Login</h1>

            <form className="login"
                  onSubmit={handleSubmit}
            >
                <input
                    type = "text"
                    value = {nombre}
                    onChange={e => setNombre(e.target.value)}
                />

                <input
                    type = "password"
                    value = {contraseña}
                    onChange={e => setNombre(e.target.value)}
                />
                <button>Iniciar sesion</button>
            </form>
            {error && <p>Todos los campos son obligatorios</p>}
        </section>
        )
}