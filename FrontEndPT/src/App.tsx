import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import SchedulePage from './pages/SchedulePage'
import NavBar from './components/Navbar'

const router = createBrowserRouter([
  {
    path: "/",
    element: <SchedulePage/>
  },
  {
    element: <NavBar />,
    children: [
      {
        path: "/schedule",
        element: <SchedulePage />
      },
      {
        path: '/patients',
        element: <SchedulePage />
      },
    ],
  },
])

function App() {

  return (
    <>
      <RouterProvider router={router} />
    </>
  )
}

export default App;
