import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import { useEffect, useState } from "react";

const OwnerRegister = () => {
  const navigate = useNavigate();
  const [name, setName] = useState('');
  const [document, setDocument] = useState('');
  const [birthdate, setBirthdate] = useState('');
  const [gender, setGender] = useState('');
  const [email, setEmail] = useState('');
  const [cellphone, setCellphone] = useState('');
  const [address, setAddress] = useState('');
  const [clinics, setClinics] = useState<Clinics[]>([]);
  const [selectedClinic, setSelectedClinic] = useState<Clinics | null>(null);
  interface Clinics {
    id: number;
    name: string;
    address: string;
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/owners', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name,
          document,
          birthdate,
          gender,
          email,
          cellphone,
          address,
          clinics: [selectedClinic],
        }),
      });

      if (response.ok) {
        console.log('Dono cadastrado com sucesso.', response);
      } else {
        alert('Falha ao cadastrar. Tente novamente.');
      }
    } catch (error) {
      alert('Erro de conexão com o servidor.');
    }
  };
 

  const handleDocumentoChange = (e) => {
    let value = e.target.value.replace(/\D/g, ''); // Remove non-digit characters
    if (value.length > 11) {
      value = value.slice(0, 11); // Limit length to 11 digits
    }
  
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})\.(\d{3})(\d)/, '$1.$2.$3');
    value = value.replace(/(\d{3})\.(\d{3})\.(\d{3})(\d)/, '$1.$2.$3-$4');
  
    setDocument(value);
  };

  const handleDataNascimentoChange = (e: { target: { value: string; }; }) => {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length > 8) {
      value = value.slice(0, 8);
    }

    value = value.replace(/^(\d{2})(\d)/, '$1/$2');
    value = value.replace(/^(\d{2})\/(\d{2})(\d)/, '$1/$2/$3');

    setBirthdate(value);
  };

  

  useEffect(() => {
    fetch('http://localhost:8080/clinic')
      .then(response => response.json())
      .then(data => {
        setClinics(data);
      })
      .catch(error => console.error('Error fetching clinic:', error));
  }, []);

  const handleClinicChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const clinicId = parseInt(event.target.value, 10);
    const clinic = clinics.find(c => c.id === clinicId);
    if (clinic) {
      setSelectedClinic(clinic);
    }
  };

  console.log(selectedClinic);

  return (
    <div className="flex h-screen p-8 bg-slate-100 gap-5 items-center justify-center">
      <div className="bg-white shadow rounded-lg p-8">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
          <div>
            <h1 className="flex text-2xl font-bold">Cadastro de dono</h1>
          </div>
          <div className="items grid grid-rows-3 grid-cols-2 gap-4">
            <InputComponent label="Nome" id={"name"} name={"name"} onChange={(e) => setName(e.target.value)} values={name} />
            <InputComponent label="CPF" id={"document"} name={"document"} onChange={handleDocumentoChange} values={document} />
            <InputComponent label="Data de nascimento" id={"birthdate"} name={"birthdate"} onChange={handleDataNascimentoChange} values={birthdate} />
            <div>
              <label>Genero</label>
              <select
                    id="gender"
                    name="gender"
                    value={gender}
                    onChange={(e) => setGender(e.target.value)}
                    className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
              >
                <option value="">Selecione</option>
                <option value="MASCULINO">Masculino</option>
                <option value="FEMININO">Feminino</option>
                <option value="OUTRO">Outro</option>
              </select>
            </div> 
            <div>
              <label htmlFor="">Clinica</label>
              <select
                className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                value={selectedClinic ? selectedClinic.id : ''}
                onChange={handleClinicChange}
              >
                <option value="">Selecione</option>
                {clinics.map((clinic) => (
                  <option key={clinic.id} value={clinic.id}>
                    {clinic.name}
                  </option>
                ))}
              </select>
            </div>
            <InputComponent label="Email" id={"email"} name={"email"} onChange={(e) => setEmail(e.target.value)} values={email} />
            <InputComponent label="Celular" id={"cellphone"} name={"cellphone"} onChange={(e) => setCellphone(e.target.value)} values={cellphone} />
            <InputComponent label="Endereço" id={"address"} name={"address"} onChange={(e) => setAddress(e.target.value)} values={address} />          </div>
          <div className="w-full flex flex-1 items-center justify-center gap-8">
            <button className="p-2 bg-green-500 rounded-md hover:opacity-60" onClick={handleSubmit}>
              <p className="text-white">Cadastrar</p>
            </button>
            <button
              className="p-2 bg-red-500 rounded-md hover:opacity-60"
              onClick={() => navigate("/owners")}
            >
              <p className="text-white">Cancelar</p>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OwnerRegister;
