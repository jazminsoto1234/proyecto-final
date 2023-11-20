import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Register.css'; 

function Register() {
 const [firstname, setFirstname] = useState('');
 const [lastname, setLastname] = useState('');
 const [email, setEmail] = useState('');
 const [password, setPassword] = useState('');
 const [ciudad, setCiudad] = useState('');
 const [provincia, setProvincia] = useState('');
 const [calle, setCalle] = useState('');
 const [referencia, setReferencia] = useState('');
 const navigate = useNavigate();

 const handleSubmit = async (e) => {
 e.preventDefault();
 try {
   const response = await axios.post('http://localhost:8090/api/auth/signup', {
     firstname: firstname,
     lastname: lastname,
     email: email,
     password: password,
     admin: false,
     direccion: {
      ciudad: ciudad,
      provincia: provincia,
      calle: calle,
      referencia: referencia
    }
   });
   console.log('Respuesta del servidor:', response.data);
   navigate('/');
 } catch (error) {
   console.error('Error al registrarse:', error);
 }
 };

 return (
  <div className="register-container">
    <h2>Registrarse</h2>
    <form onSubmit={handleSubmit} className="register-form">
      <div>
        <label>Nombre:</label>
        <input
          type="text"
          value={firstname}
          onChange={(e) => setFirstname(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Apellido:</label>
        <input
          type="text"
          value={lastname}
          onChange={(e) => setLastname(e.target.value)}
          required
        />
      </div>
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
      <div>
        <label>Ciudad:</label>
        <input
          type="text"
          value={ciudad}
          onChange={(e) => setCiudad(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Provincia:</label>
        <input
          type="text"
          value={provincia}
          onChange={(e) => setProvincia(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Calle:</label>
        <input
          type="text"
          value={calle}
          onChange={(e) => setCalle(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Referencia:</label>
        <input
          type="text"
          value={referencia}
          onChange={(e) => setReferencia(e.target.value)}
          required
        />
      </div>
      <button type="submit" className="register-button">Registrarse</button>
    </form>
  </div>
);
}

export default Register;
