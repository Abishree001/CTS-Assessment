import { Trainer } from "../components/Trainer";

const trainers = [
  new Trainer(1, "Alice Johnson", "alice@example.com", "9876543210", "React", ["Hooks", "Routing", "Redux"]),
  new Trainer(2, "Bob Smith", "bob@example.com", "7890123456", "Angular", ["Directives", "Services"]),
  new Trainer(3, "Charlie Brown", "charlie@example.com", "9012345678", "Vue", ["Vuex", "Components"])
];

export default trainers;
