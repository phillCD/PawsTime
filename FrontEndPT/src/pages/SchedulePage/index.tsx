import { Key, MouseEvent, useEffect, useState } from "react";
import "../../index.css";
import Calendar from "react-calendar";
import { Value } from "../../@types/types";
import "react-calendar/dist/Calendar.css";
import VetSelect from "../../components/VetSelect";
import Appointments from "../../components/Appointments";
import SimpleButton from "../../components/SimpleButton";
import AddIcon from "../../assets/add.svg";
import Modal from "../../components/Modal";
import InputComponent from "../../components/Input";
import SelectComponent from "../../components/Select";

export default function SchedulePage() {
  const [value, onChange] = useState<Value>(new Date());
  const [pets, setPets] = useState<any[]>([]);
  const [selectedPet, setSelectedPet] = useState<any>("");
  const [procedure, setProcedure] = useState(''); 


  const [isModalVisible, setIsModalVisible] = useState<boolean>(false);

  const [isAddAppointmentModalVisible, setIsAddAppointmentModalVisible] =
    useState<boolean>(false);

  const dateObj = new Date(value!.toString());
  const day = dateObj.getUTCDate();
  const month = dateObj.toLocaleString("default", { month: "long" }); // months from 1-12
  const year = dateObj.getUTCFullYear();

  useEffect(() => {
    fetch('http://localhost:8080/pet') // Adjust the endpoint as needed
      .then(response => response.json())
      .then(data => {
        setPets(data);
      })
      .catch(error => console.error('Error fetching owners:', error));
  }, []);

  console.log(pets);

  const handlePetChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const petId = parseInt(event.target.value, 10);
    const selectedPet = pets.find(o => o.id === petId);
    if (selectedPet) {
      setSelectedPet(selectedPet);
    }
  }

  const handleProcedureChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setProcedure(event.target.value);
  };

  // Handler for posting the appointment
  const handlePostAppointment = async () => {
    const appointmentData = {
      petId: selectedPet,
      procedure: procedure,
    };
  
    try {
      const response = await fetch('https://localhost:8080/appointments', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(appointmentData),
      });
  
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
  
      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error('Error posting the appointment:', error);
    }
  };

  return (
    <>
      {isModalVisible && (
        <Modal onClickOut={() => setIsModalVisible(false)}>
          <div className="p-6 flex flex-1 flex-col gap-6 items-center justify-center">
            <p>Criar uma agenda</p>
            <div className="flex flex-1 gap-6">
              <div className="flex flex-1 flex-col gap-6">
                <InputComponent label="Data inicio" type="date" />
                <InputComponent label="Data fim" type="date" />
              </div>
              <div className="flex flex-1 flex-col gap-6">
                <InputComponent label="Hora inicio" />
                <InputComponent label="Hora fim" />
              </div>
            </div>
            <SimpleButton label="Cadastrar" />
          </div>
        </Modal>
      )}

      {isAddAppointmentModalVisible && (
        <Modal onClickOut={() => setIsAddAppointmentModalVisible(false)}>
          <div className="p-6 flex flex-1 flex-col gap-6 items-center justify-center">
            <p>Marcar uma consulta</p>
            <div className="flex flex-1 gap-6">
              <div className="flex flex-1 flex-col gap-6">
              <label htmlFor="pet-select">Paciente</label>
              <div>
                  <select className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                          id="pet-select" onChange={handlePetChange} value={selectedPet?.id || ''}>
                    <option value=""></option>
                    {pets.map((pet) => (
                      <option key={pet.id} value={pet.id}>
                        {pet.name}
                      </option>
                    ))}
                  </select>
                </div>
                <InputComponent label="Procedimento" values={procedure} onChange={handleProcedureChange}/>
              </div>
            </div>
            <SimpleButton label="Cadastrar" onClick={handlePostAppointment}/>
          </div>
        </Modal>
      )}

      <div className="flex h-screen p-8 bg-slate-100 gap-5">
        <div>
          <Calendar
            onChange={onChange}
            value={value}
            locale="pt-BR"
            className="rounded-md bg-green-500 items-center justify-center"
            tileClassName="items-center justify-center hover:opacity-20 cursor-pointer bg-red-500"
            formatShortWeekday={(_, date) =>
              ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"][date.getDay()]
            }
          />
        </div>
        <div className="w-full gap-9">
          <div className="flex flex-row gap-6">
            <VetSelect />
            <SimpleButton
              icon={AddIcon}
              onClick={() => setIsModalVisible(true)}
            />
          </div>
          <div className="flex flex-1 flex-col bg-white mt-5 rounded-2xl p-6">
            <div className="pb-2">
              <p className="pl-2 pb-1">{`${day} de ${month} de ${year}`}</p>
              <hr className="w-52 border-green-500" />
            </div>
            <div className="flex flex-1 flex-col gap-2">
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
              <Appointments
                onClick={() => setIsAddAppointmentModalVisible(true)}
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
