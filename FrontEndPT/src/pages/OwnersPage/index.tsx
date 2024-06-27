import "../../index.css";
import "react-calendar/dist/Calendar.css";
import ListCard from "../../components/ListCard";
import { PatientDetail } from "../../components/PatientDetails";
import SimpleButton from "../../components/SimpleButton";
import AddIcon from "../../assets/add.svg";
import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { fetchGet } from "../../service/api";

export default function OwnersPage() {
  const navigate = useNavigate();
  const { clinicId } = useParams();

  const [ownerList, setOwnerList] = useState<[]>([]);

  const getOwners = async () => {
    const res = await fetchGet(`owners/clinics/${clinicId}`);
    console.log(res);

    setOwnerList(res);
  };

  useEffect(() => {
    getOwners();
  }, []);

  return (
    <div className="flex flex-1 h-screen p-8 bg-slate-100 gap-5">
      <PatientDetail
        image="https://img.freepik.com/fotos-gratis/retrato-de-homem-feliz-e-sorridente_23-2149022620.jpg"
        petName="Nome do dono"
        type="(48) 9 9999-9999"
        breed="teste@email.com"
        gender=""
        ownerName="000.000.000-00"
      />
      <div className="w-full gap-9">
        <div className="bg-white w-full flex flex-1 flex-row text-center rounded-md items-center justify-center">
          <div className="bg-white w-full text-center rounded-md p-4">
            <p>Donos</p>
          </div>
          <div className="mr-3">
            <SimpleButton
              icon={AddIcon}
              onClick={() => navigate("/registerowner")}
            />
          </div>
        </div>
        <div className="flex flex-1 flex-col bg-white mt-5 rounded-2xl p-6">
          <div className="flex flex-1 flex-col gap-2">
            <div className="flex flex-row w-full p-2 px-10 bg-slate-400 rounded-md items-center">
              <div className="flex flex-row flex-1 justify-between">
                <p>Nome</p>
                <p>Telefone</p>
                <p>CPF</p>
              </div>
            </div>
            {ownerList.map((item) => (
              <ListCard
                key={item.id}
                id="ID"
                breed={item.name}
                petName={item.cellphone}
                ownerName={item.document}
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}
