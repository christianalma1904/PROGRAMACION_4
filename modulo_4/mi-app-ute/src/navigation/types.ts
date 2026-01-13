export type RootStackParamList = {
  Home: undefined;
  Products: undefined;
  Details: { id: string; title: string };
  Profile: { userId: string; name: string, lastname: string };
};