import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";

const OwnerRegister = () => {
  const navigate = useNavigate();

  return (
    <div className="flex h-screen p-8 bg-slate-100 gap-5 items-center justify-center">
      <div className="bg-white shadow rounded-lg p-8">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <div>
                <h1 className="flex text-2xl font-bold">Cadastro de dono</h1>
            </div>
            <div className="items grid grid-rows-3 grid-cols-2 gap-4">
              <InputComponent label="Nome" />
              <InputComponent label="CPF" />
              <InputComponent label="Data de nascimento" />
              <InputComponent label="Gênero" />
              <InputComponent label="Email" />
              <InputComponent label="Celular" />
              <InputComponent label="Endereço" />
              <InputComponent label="Bairro" />
              <InputComponent label="Cidade" />
            </div>
            <div className="w-full flex flex-1 items-center justify-center gap-8">
                <button className="p-2 bg-green-500 rounded-md hover:opacity-60">
                    <p className="text-white">Cadastrar</p>
                </button>
                <button className="p-2 bg-red-500 rounded-md hover:opacity-60" onClick={() => navigate("/owners")}>
                    <p className="text-white">Cancelar</p>
                </button>
            </div>
          </div>
      </div>
    </div>
  );
}

export default OwnerRegister;