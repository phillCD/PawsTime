import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";

export default function Login() {
  const navigate = useNavigate();

  return (
    <div className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
      <div className="bg-white w-5/12 p-6 rounded-md">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <img src="src\assets\logotipo.png" style={{width: 200, height: 100, objectFit: 'cover', borderRadius: 50}} />
            <InputComponent label="Login" />
            <InputComponent label="Senha" />
            <div className="w-full flex flex-1 items-center justify-center gap-8">
                <SimpleButton label="Entrar" onClick={() => navigate('/schedule')}/>
                <SimpleButton label="Cadastrar" onClick={() => navigate('/sign-up')}/>
            </div>
        </div>
      </div>
    </div>
  );
}
