import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";

const PatientsRegister = () => {
  const navigate = useNavigate();

  return (
    <div className="flex h-screen p-8 bg-slate-100 gap-5 items-center justify-center">
      <div className="bg-white shadow rounded-lg p-8">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <div>
                <h1 className="flex text-2xl font-bold">Cadastro de Paciente</h1>
            </div>
            <div className="items grid grid-rows-2 grid-cols-2 gap-4">
              <InputComponent label="Nome" />
              <InputComponent label="Tipo(Gato, Cachorro, etc...)" />
              <InputComponent label="Raça" />
              <InputComponent label="Sexo" />
              <InputComponent label="Idade" />
              <InputComponent label="Dono" />
            </div>
            <div className="w-full flex flex-1 items-center justify-center gap-8">
                <button className="p-2 bg-green-500 rounded-md hover:opacity-60">
                    <p className="text-white">Cadastrar</p>
                </button>
                <button className="p-2 bg-red-500 rounded-md hover:opacity-60" onClick={() => navigate("/patients")}>
                    <p className="text-white">Cancelar</p>
                </button>
            </div>
          </div>
      </div>
    </div>
  );
}

export default PatientsRegister;