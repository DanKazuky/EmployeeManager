import { useState } from "react";

export default function EmployeeLookup() {
  const [employeeId, setEmployeeId] = useState("");
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchEmployees = async () => {
    setLoading(true);
    setError(null);
    try {
      const url = employeeId
        ? `http://localhost:8080/api/employees/${employeeId}`
        : `http://localhost:8080/api/employees`;
      
      const response = await fetch(url);
      if (!response.ok) throw new Error("Error al obtener los datos");
      const data = await response.json();
      
      setEmployees(Array.isArray(data) ? data : [data]);
    } catch (err) {
      setError(err.message);
      setEmployees([]);
    }
    setLoading(false);
  };

  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto", backgroundColor: "#474747", color: "white", borderRadius: "8px" }}>
      <h2 style={{ textAlign: "center", color: "#ab49cc" }}>Consulta de Empleados</h2>
      <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
        <input
          type="number"
          placeholder="Ingrese ID del empleado (opcional)"
          value={employeeId}
          onChange={(e) => setEmployeeId(e.target.value)}
          style={{ flex: 1, padding: "8px", border: "1px solid #8e22bb", borderRadius: "4px", backgroundColor: "#636363", color: "white" }}
        />
        <button onClick={fetchEmployees} style={{ padding: "8px 12px", border: "none", background: "#7f00b2", color: "white", borderRadius: "4px", cursor: "pointer" }}>Buscar</button>
      </div>
      {loading && <p>Cargando...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}
      <div>
        {employees.map((emp) => (
          <div key={emp.id} style={{ padding: "10px", border: "1px solid #ab49cc", borderRadius: "4px", marginBottom: "10px", backgroundColor: "#636363" }}>
            <p><strong>ID:</strong> {emp.id}</p>
            <p><strong>Nombre:</strong> {emp.name}</p>
            <p><strong>Salario:</strong> ${emp.salary}</p>
            <p><strong>Edad:</strong> {emp.age}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
