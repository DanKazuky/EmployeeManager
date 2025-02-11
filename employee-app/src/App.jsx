import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EmployeeLookup from "./components/EmployeeLookup";


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className="p-10">
        <h1 className="text-2xl font-bold mb-4">Consulta de Empleados</h1>
        <EmployeeLookup />
      </div>

    </>
  )
}

export default App
