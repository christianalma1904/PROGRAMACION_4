import { createNativeStackNavigator } from "@react-navigation/native-stack";
import type { RootStackParamList } from "@/navigation/types";
import { HomeScreen } from "@/screens/HomeScreen";
import { ProfileScreen } from "@/screens/ProfileScreen";
import { DetailsScreen } from "@/screens/DetailsScreen";
import { ProductsListScreen } from "@/screens/ProductsListScreen";
import { DisplayName } from "@/screens/DisplayName";


const Stack = createNativeStackNavigator<RootStackParamList>();

export function AppNavigator() {
  return (
    <Stack.Navigator
      screenOptions={{
        headerStyle: { backgroundColor: "#0d1117" },
        headerTintColor: "#58a6ff",
        headerTitleStyle: { fontWeight: "900" },
        contentStyle: { backgroundColor: "#0d1117" },
      }}
    >
      <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Inicio" }} />
      <Stack.Screen name="Details" component={DetailsScreen} options={{ title: "Detalles" }} />
      <Stack.Screen name="Products" component={ProductsListScreen} options={{ title: "Productos" }} />
      <Stack.Screen name="Profile" component={ProfileScreen} options={{ title: "Perfil" }}/>
      <Stack.Screen name="DisplayName" component={DisplayName} options={{ title: "DisplayName" }} />
    </Stack.Navigator>
  );
}