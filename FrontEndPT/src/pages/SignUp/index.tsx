import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";
import { useEffect, useState } from "react";

const SignUp = () => {
  const navigate = useNavigate();
  const [name, setNome] = useState('');
  const [login, setLogin] = useState('');
  const [birthdate, setDataNascimento] = useState('');
  const [gender, setGenero] = useState('');
  const [cellphone, setCelular] = useState('');
  const [document, setDocumento] = useState('');
  const [address, setEndereco] = useState('');
  const [speciality, setEspecialidade] = useState('');
  const [password, setSenha] = useState('');
  const [confirmarSenha, setConfirmarSenha] = useState('');
  const [error, setError] = useState('');


  const handleSubmit = async () => {
    e.preventDefault();
    if (password !== confirmarSenha) {
      setError('As senhas não coincidem.');
      return;
    }
    try {
      const response = await fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name,
          login,
          birthdate,
          gender,
          cellphone,
          document,
          address,
          speciality,
          password,
        }),
      });

      if (response.ok) {
        navigate('/schedule');
      } else {
        setError('Falha ao cadastrar. Tente novamente.');
      }
    } catch (error) {
      setError('Erro de conexão com o servidor.');
    }
  };

  const handleDataNascimentoChange = (e: { target: { value: string; }; }) => {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length > 8) {
      value = value.slice(0, 8);
    }

    value = value.replace(/^(\d{2})(\d)/, '$1/$2');
    value = value.replace(/^(\d{2})\/(\d{2})(\d)/, '$1/$2/$3');

    setDataNascimento(value);
  };

  const handleDocumentoChange = (e) => {
    let value = e.target.value.replace(/\D/g, ''); // Remove non-digit characters
    if (value.length > 11) {
      value = value.slice(0, 11); // Limit length to 11 digits
    }
  
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})\.(\d{3})(\d)/, '$1.$2.$3');
    value = value.replace(/(\d{3})\.(\d{3})\.(\d{3})(\d)/, '$1.$2.$3-$4');
  
    setDocumento(value);
  };

  const handleSignUp = async (e) => {
    e.preventDefault(); // Prevent default form submission behavior
  
    if (password !== confirmarSenha) {
      setError('As senhas não coincidem.');
      return;
    }
  
    const formData = {
      name: name,
      login: login,
      birthdate: birthdate,
      gender: gender,
      cellphone: cellphone,
      document: document,
      address: address,
      speciality: speciality,
      password: password,
    };
  
    try {
      const response = await fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });
  
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
  
      const data = await response.json();
      console.log('SignUp successful:', data);
    } catch (error) {
      console.error('SignUp failed:', error);
    }
  };


  return (
    <form onSubmit={handleSubmit} className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
      <div className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
        <div className="bg-white p-6 rounded-md">
          <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
              <img src="src\assets\logotipo.png" style={{width: 200, height: 100, objectFit: 'cover', borderRadius: 50}} />
              <div className="grid grid-rows-3 grid-cols-4 gap-4">
                <InputComponent label="Nome" values={name} id={"name"} name={"name"} onChange={(e) => setNome(e.target.value)}/>
                <InputComponent label="Login" id={"login"} name={"login"} onChange={(e) => setLogin(e.target.value)} values={login}/>
                <InputComponent label="Data de nascimento" values={birthdate} onChange={handleDataNascimentoChange} id="birthdate" name="birthdate" />
                <div>
                  <label>Genero</label>
                  <select
                    id="gender"
                    name="gender"
                    value={gender}
                    onChange={(e) => setGenero(e.target.value)}
                    className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                  >
                    <option value="">Selecione</option>
                    <option value="MASCULINO">Masculino</option>
                    <option value="FEMININO">Feminino</option>
                    <option value="OUTRO">Outro</option>
                  </select>
                </div>
                <InputComponent label="Celular" id={"cellphone"} name={"cellphone"} onChange={(e) => setCelular(e.target.value)} values={cellphone} />
                <InputComponent label="CPF" id={"document"} name={"document"} onChange={handleDocumentoChange} values={document} />
                <InputComponent label="Endereço" id={"address"} name={"address"} onChange={(e) => setEndereco(e.target.value)} values={address} />
                <InputComponent label="Especialidade" id={"speciality"} name={"speciality"} onChange={(e) => setEspecialidade(e.target.value)} values={speciality} />
                <InputComponent label="Senha" type="password" id={"password"} name={"password"} onChange={(e) => setSenha(e.target.value)} values={password} />
                <InputComponent label="Confirme sua senha" type="password" id={"confirmPassword"} name={"confirmPassword"} onChange={(e) => setConfirmarSenha(e.target.value)} values={confirmarSenha} />
              </div>
              <div className="w-full flex flex-1 items-center justify-center gap-8">
                  <SimpleButton label="Cadastrar" onClick={handleSignUp}/>
                  <SimpleButton label="Voltar" onClick={() => navigate("/")}/>
              </div>
            </div>
        </div>
      </div>
    </form>
  );
}

export default SignUp;