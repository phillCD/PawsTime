import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";
import { useFormik } from "formik";
import { fetchPost } from "../../service/api";
import { useEffect, useState } from "react";

const PatientsRegister = () => {
  const navigate = useNavigate();
  const [name, setName] = useState('');
  const [animal, setAnimal] = useState('');
  const [breed, setBreed] = useState('');
  const [breeds, setBreeds] = useState<Breed[]>([]); 
  const [gender, setGender] = useState('');
  const [age, setAge] = useState('');
  const [owner, setOwner] = useState('');
  const [owners, setOwners] = useState<Owner[]>([]);
  const [error, setError] = useState('');

  interface Owner {
    id: number;
    name: string;
    email: string;
    cellphone: string;
    address: string;
    document: string;
    birthdate: string;
    gender: string;
  }

  interface Breed {
    id: number;
    name: string;
  }

  enum AnimalType {
    DOG = "Cachorro",
    CAT = "Gato",
    BIRD = "Pássaro",
    RODENT = "Roedor",
    FISH = "Peixe",
    REPTILE = "Réptil",
    AMPHIBIAN = "Anfíbio",
    INVERTEBRATE = "Invertebrado",
  }

  function getKeyByValue(value: string): string | undefined {
    const entries = Object.entries(AnimalType);
    const foundEntry = entries.find(([, enumValue]) => enumValue === value);
    return foundEntry ? foundEntry[0] : undefined;
  }

  const animalKey = getKeyByValue(animal);

  const ownerObject = owners.map((owner) => ({
      id : owner.id,
      name: owner.name,
      email: owner.email,
      cellphone: owner.cellphone,
      address: owner.address,
      document: owner.document,
      birthdate: owner.birthdate,
  }));

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log(owner);
      const selectedOwnerObject = ownerObject[Number(owner)];

      const response = await fetch('http://localhost:8080/pet', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        // Wrap the pet information in an array
        body: JSON.stringify({
          name,
          breed,
          gender,
          age,
          owner: selectedOwnerObject,
        }),
      });
  

      if (response.ok) {
        console.log(selectedOwnerObject)
        console.log('Pet cadastrado com sucesso!');
      } else {
        setError('Falha ao cadastrar. Tente novamente.');
      }
    } catch (error) {
      setError('Erro de conexão com o servidor.');
    }
  }

  useEffect(() => {
    if (animal) {
      fetch(`http://localhost:8080/breed/animal/${animalKey}`)
        .then(response => response.json())
        .then(data => {
          setBreeds(data);
          // Set breed to the first breed in the list if breeds are fetched successfully
          if (data.length > 0) {
            setBreed(data[0].id); // Assuming each breed object has an id
          }
        })
        .catch(error => console.error('Error fetching breeds:', error));
    }
  }, [animal]);

  useEffect(() => {
    fetch('http://localhost:8080/owners')
      .then(response => response.json())
      .then(data => {
        console.log(data);
        setOwners(data);
      })
      .catch(error => console.error('Error fetching owners:', error));
  }, []);

  return (
    <div className="flex h-screen p-8 bg-slate-100 gap-5 items-center justify-center">
      <div className="bg-white shadow rounded-lg p-8">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
            <div>
                <h1 className="flex text-2xl font-bold">Cadastro de Paciente</h1>
            </div>
            <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
              <div className="items grid grid-rows-2 grid-cols-2 gap-4">
                <InputComponent label="Nome" id="name" name="name" onChange={(e) => setName(e.target.value)} values={name} />
                <div>
                  <label htmlFor="animal">Animal</label>
                  <select className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                   id="animal" name="animal" onChange={(e) => setAnimal(e.target.value)} value={animal}>
                    {Object.entries(AnimalType).map(([key, type]) => (
                      <option key={key} value={type}>{type}</option>
                    ))}
                  </select>
                </div>
                <div>
                  <label htmlFor="breed">Raça</label>
                  <select className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                    id="breed" name="breed" onChange={(e) => setBreed(e.target.value)} value={breed}>
                    {Array.isArray(breeds) ? breeds.map((breed) => (
                    <option key={breed.id} value={breed.name}>{breed.name}</option>
                  )) : null}
                  </select>
                </div>
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
                <InputComponent label="Idade" id="age" name="age" onChange={(e) => setAge(e.target.value)} values={age}/>
                <div>
                  <label>Dono</label>
                  <select
                    className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                    id="owner"
                    name="owner"
                    value={owner} // Ensure this is correctly initialized in your state
                    onChange={(e) => {
                      console.log("Selected owner ID:", e.target.value); // Debugging line
                      setOwner(e.target.value);
                    }}
                  >
                    <option value="">Selecione</option>
                    {owners.map((owner) => (
                      <option key={owner.id} value={owner.id}>
                        {owner.name}
                      </option>
                    ))}
                  </select>
                </div>
              </div>
              <div className="w-full flex flex-1 items-center justify-center gap-8">
                  <button className="p-2 bg-green-500 rounded-md hover:opacity-60" type="button" onClick={handleSubmit}>
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