import { useState } from "react";

const EmployeeTable = () => {
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

      setEmployees(employeeId ? [data.data] : data.data || data);
    } catch (err) {
      setError(err.message);
      setEmployees([]);
    }
    setLoading(false);
  };

  return (
    <div style={{ padding: "20px", maxWidth: "800px", margin: "auto", backgroundColor: "#474747", color: "white", borderRadius: "8px" }}>
      <h2 style={{ textAlign: "center", color: "#ab49cc" }}>Consulta de Empleados</h2>
      <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
        <input
          type="number"
          placeholder="Ingrese ID del empleado (opcional)"
          value={employeeId}
          onChange={(e) => setEmployeeId(e.target.value)}
          style={{ flex: 1, padding: "8px", border: "1px solid #8e22bb", borderRadius: "4px", backgroundColor: "#636363", color: "white" }}
        />
        <button onClick={fetchEmployees} style={{ padding: "8px 12px", border: "none", background: "#7f00b2", color: "white", borderRadius: "4px", cursor: "pointer" }}>
          Buscar
        </button>
      </div>
      {loading && <p>Cargando...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "20px", backgroundColor: "#636363" }}>
        <thead>
          <tr style={{ backgroundColor: "#7f00b2", color: "white" }}>
            <th style={tableHeaderStyle}>ID</th>
            <th style={tableHeaderStyle}>Nombre</th>
            <th style={tableHeaderStyle}>Salario</th>
            <th style={tableHeaderStyle}>Edad</th>
          </tr>
        </thead>
        <tbody>
          {employees.length > 0 ? (
            employees.map((emp) => (
              <tr key={emp.id} style={{ textAlign: "center", borderBottom: "1px solid #ab49cc" }}>
                <td style={tableCellStyle}>{emp.id}</td>
                <td style={tableCellStyle}>{emp.employee_name}</td>
                <td style={tableCellStyle}>${emp.employee_salary}</td>
                <td style={tableCellStyle}>{emp.employee_age}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" style={{ textAlign: "center", padding: "10px", color: "#fff" }}>No se encontraron empleados</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

const tableHeaderStyle = { padding: "10px", borderBottom: "2px solid #ab49cc", textAlign: "center" };
const tableCellStyle = { padding: "10px", textAlign: "center", backgroundColor: "#474747" };

export default EmployeeTable;
