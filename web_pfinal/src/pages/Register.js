import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Register() {
 const [firstname, setFirstname] = useState('');
 const [lastname, setLastname] = useState('');
 const [email, setEmail] = useState('');
 const [password, setPassword] = useState('');
 const navigate = useNavigate();

 const handleSubmit = async (e) => {
 e.preventDefault();
 try {
   const response = await axios.post('http://localhost:8090/api/auth/signup', {
     firstname: firstname,
     lastname: lastname,
     email: email,
     password: password,
     admin: false
   });
   console.log('Respuesta del servidor:', response.data);
   navigate('/');
 } catch (error) {
   console.error('Error al registrarse:', error);
 }
 };

 return (
 <div>
   <h2>Registrarse</h2>
   <form onSubmit={handleSubmit}>
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
     <button type="submit">Registrarse</button>
   </form>
 </div>
 );
}

export default Register;
