import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";

const SignUp = () => {
  const navigate = useNavigate();

  return (
    <div className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
      <div className="bg-white p-6 rounded-md">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <img src="src\assets\logotipo.png" style={{width: 200, height: 100, objectFit: 'cover', borderRadius: 50}} />
            <div className="grid grid-rows-3 grid-cols-4 gap-4">
              <InputComponent label="Nome" />
              <InputComponent label="Data de nascimento" />
              <InputComponent label="Gênero" />
              <InputComponent label="Celular" />
              <InputComponent label="Documento" />
              <InputComponent label="Endereço" />
              <InputComponent label="Especialidade" />
              <InputComponent label="Email" />
              <InputComponent label="Senha" />
              <InputComponent label="Confirme sua senha" />
            </div>
            <div className="w-full flex flex-1 items-center justify-center gap-8">
                <SimpleButton label="Cadastrar" onClick={() => navigate('/schedule')}/>
                <SimpleButton label="Voltar" onClick={() => navigate(-1)}/>
            </div>
          </div>
      </div>
    </div>
  );
}

export default SignUp;