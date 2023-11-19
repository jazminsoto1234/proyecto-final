import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import axios from 'axios';

function Register() {
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [ciudad, setCiudad] = useState('');
  const [provincia, setProvincia] = useState('');
  const [calle, setCalle] = useState('');
  const [referencia, setReferencia] = useState('');

  const handleSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:8090/api/auth/signup', {
        firstname,
        lastname,
        email,
        password,
        admin: false,
        direccion: {
          ciudad,
          provincia,
          calle,
          referencia,
        },
      });
      console.log('Respuesta del servidor:', response.data);
      // Aquí podrías agregar la navegación a la pantalla de inicio o hacer cualquier otra acción necesaria
    } catch (error) {
      console.error('Error al registrarse:', error);
    }
  };

  return (
    <View style={styles.container}>
      <Text>Registrarse</Text>
      <TextInput
        style={styles.input}
        value={firstname}
        onChangeText={(text) => setFirstname(text)}
        placeholder="Nombre"
      />
      <TextInput
        style={styles.input}
        value={lastname}
        onChangeText={(text) => setLastname(text)}
        placeholder="Apellido"
      />
      <TextInput
        style={styles.input}
        value={email}
        onChangeText={(text) => setEmail(text)}
        placeholder="Correo electrónico"
        keyboardType="email-address"
      />
      <TextInput
        style={styles.input}
        value={password}
        onChangeText={(text) => setPassword(text)}
        placeholder="Contraseña"
        secureTextEntry={true}
      />
      <TextInput
        style={styles.input}
        value={ciudad}
        onChangeText={(text) => setCiudad(text)}
        placeholder="Ciudad"
      />
      <TextInput
        style={styles.input}
        value={provincia}
        onChangeText={(text) => setProvincia(text)}
        placeholder="Provincia"
      />
      <TextInput
        style={styles.input}
        value={calle}
        onChangeText={(text) => setCalle(text)}
        placeholder="Calle"
      />
      <TextInput
        style={styles.input}
        value={referencia}
        onChangeText={(text) => setReferencia(text)}
        placeholder="Referencia"
      />
      <Button title="Registrarse" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 10,
    width: '100%',
  },
});

export default Register;
