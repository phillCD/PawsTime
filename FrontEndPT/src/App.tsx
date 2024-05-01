import { RouterProvider, createBrowserRouter } from "react-router-dom";
import SchedulePage from "./pages/SchedulePage";
import NavBar from "./components/Navbar";
import PatientsPage from "./pages/PatientsPage";
import OwnersPage from "./pages/OwnersPage";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";
import OwnerRegister from "./pages/OwnersRegistration";
import PatientsRegister from "./pages/PatientsRegistration";
import Profile from "./pages/Profile";
import Enchiridion from "./pages/Enchiridion";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },
  {
    path: "/sign-up",
    element: <SignUp />,
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
      {
        path: "/owners",
        element: <OwnersPage />,
      },
      {
        path: "/registerowner",
        element: <OwnerRegister />,
      },
      {
        path: "/registerpet",
        element: <PatientsRegister />,
      },
      {
        path: "/profile",
        element: <Profile />,
      },
      {
        path: "/enchiridion",
        element: <Enchiridion />,
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
