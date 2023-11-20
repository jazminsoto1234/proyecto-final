import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Login.css';


function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);
  const navigate = useNavigate(); 

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8090/api/auth/signin', {
        email: email,
        password: password
      });
      const { token } = response.data;
      localStorage.setItem('token', token);
      setLoggedIn(true);
      navigate('/home');

      console.log('Respuesta del servidor:', response.data);
      
    } catch (error) {
      console.error('Error al iniciar sesión:', error);
    }
  };

  return  (
    <div className="login-container">
      {!loggedIn ? (
        <div className="login-form">
          <h2>Iniciar sesión</h2>
          <form onSubmit={handleSubmit}>
            <div>
              <label>Correo electrónico:</label>
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div>
              <label>Contraseña:</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <button type="submit" className="submit-button">Iniciar sesión</button>
          </form>
          <button onClick={() => navigate('/register')} className="register-button">Registrarse</button>
        </div>
      ) : null}
    </div>
  );
}

export default Login;
