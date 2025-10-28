import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import SaludoProps from './src/components/SaludoProps';
import Saludo from './src/components/Saludo';
import Contador from './src/components/Contador';
import Caja from './src/components/Caja';

export default function App() {
  return (
    <View style={styles.container}>
      <Saludo />
      <Text>Open up App.tsx to start working on your app!</Text>
      <StatusBar style="auto" />
      <SaludoProps nombre='Christian' />
      <Contador />
      <Caja />
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
