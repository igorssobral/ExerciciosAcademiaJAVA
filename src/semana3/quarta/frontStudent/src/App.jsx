import { useState, useEffect } from "react"
import axios from "axios"
import "./App.css"

function App() {
  const [student, setStudent] = useState({
    name: "",
    age: "",
    email: "",
  })

  const [students, setStudents] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState("")

  const fetchStudents = async () => {
    setLoading(true)
    setError("") 
    try {
      const response = await axios.get("http://localhost:8080/api/students")
      setStudents(response.data)
    } catch (error) {
      setError("Erro ao buscar estudantes.")
      console.error("Erro ao buscar estudantes:", error)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchStudents()
  }, [])

  const handleChange = (e) => {
    const { name, value } = e.target
    setStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value,
    }))
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const response = await axios.post(
        "http://localhost:8080/api/students",
        student
      )
      setStudents((prevStudents) => [
        ...prevStudents,
        { ...student, id: response.data },
      ])
      setStudent({ name: "", age: "", email: "" }) 
    } catch (error) {
      setError("Erro ao salvar estudante.")
      console.error("Erro ao salvar estudante:", error)
    }
  }

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/students/${id}`)
      setStudents((prevStudents) => prevStudents.filter((s) => s.id !== id))
    } catch (error) {
      setError("Erro ao deletar estudante.")
      console.error("Erro ao deletar estudante:", error)
    }
  }

  return (
    <div>
      <h1>Gerenciamento de Estudantes</h1>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <form onSubmit={handleSubmit}>
        <label htmlFor="name">Nome</label>
        <input
          type="text"
          id="name"
          name="name"
          value={student.name}
          onChange={handleChange}
          required
        />
        <label htmlFor="age">Idade</label>
        <input
          type="number"
          id="age"
          name="age"
          value={student.age}
          onChange={handleChange}
          required
        />
        <label htmlFor="email">Email</label>
        <input
          type="email"
          id="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          required
        />
        <button type="submit" disabled={loading}>
          {loading ? "Salvando..." : "Salvar Estudante"}
        </button>
      </form>

      <h2>Lista de Estudantes</h2>
      {loading ? (
        <p>Carregando estudantes...</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Idade</th>
              <th>Email</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.name}</td>
                <td>{s.age}</td>
                <td>{s.email}</td>
                <td>
                  <button onClick={() => handleDelete(s.id)}>Deletar</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  )
}

export default App
