export type Product = {
  id: string;
  name: string;
  price: number;
};

export const PRODUCTS: Product[] = [
  { id: "p1", name: "Mouse", price: 12 },
  { id: "p2", name: "Keyboard", price: 25 },
  { id: "p3", name: "Monitor", price: 180 },
  { id: "p4", name: "Laptop Stand", price: 30 },
  { id: "p5", name: "Headset", price: 45 },
];