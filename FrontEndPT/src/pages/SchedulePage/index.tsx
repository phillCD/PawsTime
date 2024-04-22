import { useState } from "react";
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

  const [isModalVisible, setIsModalVisible] = useState<boolean>(false);

  const [isAddAppointmentModalVisible, setIsAddAppointmentModalVisible] =
    useState<boolean>(false);

  const dateObj = new Date(value!.toString());
  const day = dateObj.getUTCDate();
  const month = dateObj.toLocaleString("default", { month: "long" }); // months from 1-12
  const year = dateObj.getUTCFullYear();

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
                <SelectComponent label="Paciente" />
                <InputComponent label="Procedimento" />
              </div>
            </div>
            <SimpleButton label="Cadastrar" />
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
