import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Alert } from 'react-native';
import axios from 'axios';

function Login({ navigation }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:8090/api/auth/signin', {
        email: email,
        password: password,
      });
      const { token } = response.data;
      // Aquí podrías guardar el token en AsyncStorage para persistencia

      navigation.navigate('Home'); // Cambia 'Home' por el nombre de tu pantalla principal
      console.log('Respuesta del servidor:', response.data);
    } catch (error) {
      console.error('Error al iniciar sesión:', error);
      Alert.alert('Error', 'Credenciales inválidas. Por favor, inténtalo de nuevo.');
    }
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        value={email}
        onChangeText={(text) => setEmail(text)}
        placeholder="Correo electrónico"
      />
      <TextInput
        style={styles.input}
        value={password}
        onChangeText={(text) => setPassword(text)}
        placeholder="Contraseña"
        secureTextEntry={true}
      />
      <Button title="Iniciar sesión" onPress={handleSubmit} />
      <Button
        title="Registrarse"
        onPress={() => navigation.navigate('Register')} // Cambia 'Register' por el nombre de tu pantalla de registro
      />
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

export default Login;
