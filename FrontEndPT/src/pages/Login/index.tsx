import { SetStateAction, useState } from "react";
import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";

export default function Login() {
  const navigate = useNavigate();
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e: { preventDefault: () => void }) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/users/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ login, password }),
      });

      if (response.ok) {
        const data = await response.json();
        localStorage.setItem("userId", data.id);
        localStorage.setItem("clinicId", data.clinics_id.id);
        console.log(data.clinics_id);
        navigate("/schedule");
      } else {
        setError("Login failed. Please check your credentials.");
      }
    } catch (error) {
      setError("An error occurred. Please try again later.");
    }
  };

  return (
    <div className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
      <div className="bg-white w-5/12 p-6 rounded-md">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
          <img
            src="src\\assets\\logotipo.png"
            style={{
              width: 200,
              height: 100,
              objectFit: "cover",
              borderRadius: 50,
            }}
          />
          <InputComponent
            label="Login"
            id="login"
            name="login"
            onChange={(e: { target: { value: SetStateAction<string> } }) =>
              setLogin(e.target.value)
            }
            values={login}
          />
          <InputComponent
            label="Senha"
            id="password"
            name="password"
            onChange={(e: { target: { value: SetStateAction<string> } }) =>
              setPassword(e.target.value)
            }
            values={password}
          />
          {error && <div style={{ color: "red" }}>{error}</div>}
          <div className="w-full flex flex-1 items-center justify-center gap-8">
            <SimpleButton label="Entrar" onClick={handleLogin} />
            <SimpleButton
              label="Cadastrar"
              onClick={() => navigate("/sign-up")}
            />
          </div>
        </div>
      </div>
    </div>
  );
}
