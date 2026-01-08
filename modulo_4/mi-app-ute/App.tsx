// App.tsx principal - Punto de entrada
import React from 'react';
import { SafeAreaView, StatusBar } from 'react-native';
import TypeScriptDemo from './src/screens/TypeScriptDemo';
import { StyleSheet, Text, View } from "react-native";
import { AppTitle } from "@/components/common/AppTitle";
import AppButton from '@/components/AppButton';
import { ClockDemo } from '@/screens/ClockDemo';
import { UseEffectAsyncDemo } from '@/screens/UseEffectAsyncDemo';
import { AbortFetchDemo } from '@/screens/AbortFetchDemo';
import { ProductsDemo } from '@/screens/Productos';
import { Parte09Lab } from '@/screens/Parte09Lab';
import { Parte11Lab } from '@/screens/Parte11Lab';
import { Parte12Lab } from '@/screens/Parte12Lab';

function App(): React.JSX.Element {
  return (
    <>
      <Parte12Lab />
      <StatusBar/>
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
    padding: 16,
  },
  h1: {
    color: "#58a6ff",
    fontWeight: "900",
    fontSize: 18,
    marginBottom: 12,
  },
  stage: {
    flex: 1,
    borderRadius: 12,
    overflow: "hidden",
    borderWidth: 1,
    borderColor: "#30363d",
  },
  help: {
    marginTop: 12,
    color: "#8b949e",
    lineHeight: 18,
  },
});