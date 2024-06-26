import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";
import { useFormik } from "formik";
import { fetchPost } from "../../service/api";

const PatientsRegister = () => {
  const navigate = useNavigate();

  const formik = useFormik({
    initialValues: {
      name: "",
      breed: {
        id: "1",
        name: "Bulldog",
      },
      gender: "",
      idade: "",
      owner: "",
    },
    onSubmit: values => {
      alert(JSON.stringify(values));
      //addPatient(JSON.stringify(values))
    }
  })

  /* const addPatient = async (values: any) => {
    fetchPost('pet', {...values, breed: {
      id: "1",
      name: "Bulldog",
    }})
  } */



  return (
    <div className="flex h-screen p-8 bg-slate-100 gap-5 items-center justify-center">
      <div className="bg-white shadow rounded-lg p-8">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <div>
                <h1 className="flex text-2xl font-bold">Cadastro de Paciente</h1>
            </div>
            <form className="flex flex-col gap-4" onSubmit={formik.handleSubmit}>
              <div className="items grid grid-rows-2 grid-cols-2 gap-4">
                <InputComponent label="Nome" id="name" name="name" onChange={formik.handleChange} values={formik.values.name} />
                <InputComponent label="Raça" />
                <InputComponent label="Sexo" id="gender" name="gender" onChange={formik.handleChange} values={formik.values.gender}/>
                <InputComponent label="Idade" id="age" name="age" onChange={formik.handleChange} values={formik.values.age}/>
                <InputComponent label="Dono" id="owner" name="owner" onChange={formik.handleChange} values={formik.values.owner}/>
              </div>
              <div className="w-full flex flex-1 items-center justify-center gap-8">
                  <button className="p-2 bg-green-500 rounded-md hover:opacity-60" type="submit">
                      <p className="text-white">Cadastrar</p>
                  </button>
                  <button className="p-2 bg-red-500 rounded-md hover:opacity-60" onClick={() => navigate("/patients")}>
                      <p className="text-white">Cancelar</p>
                  </button>
              </div>
            </form>
          </div>
      </div>
    </div>
  );
}

export default PatientsRegister;