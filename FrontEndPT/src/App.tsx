import { RouterProvider, createBrowserRouter } from "react-router-dom";
import SchedulePage from "./pages/SchedulePage";
import NavBar from "./components/Navbar";
import PatientsPage from "./pages/PatientsPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <SchedulePage />,
  },
  {
    element: <NavBar />,
    children: [
      {
        path: "/schedule",
        element: <SchedulePage />,
      },
      {
        path: "/patients",
        element: <PatientsPage />,
      },
    ],
  },
]);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
