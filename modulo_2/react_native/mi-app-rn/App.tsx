import { StyleSheet, Text, View } from 'react-native';
import Saludo from "./src/components/Saludo";
import SaludoProps from "./src/components/SaludoProps";
import Contador from './src/components/Contador';
import Caja from './src/components/Caja';
import Perfil from './src/components/Perfil';

export default function App() {
  return (
    <View style={styles.container}>
      <Saludo />
      <Text>Open up App.tsx to start working on your app!</Text>
      <SaludoProps nombre="Francisco" />
      <Contador/>
      <Caja/>
      <Perfil/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
