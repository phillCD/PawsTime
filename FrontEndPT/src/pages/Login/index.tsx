import { useNavigate } from "react-router-dom";
import InputComponent from "../../components/Input";
import SimpleButton from "../../components/SimpleButton";
import { useFormik } from "formik";
import { fetchPost } from "../../service/api";
import { useAuthContext } from "../../context/AuthContext/UseAuthContext";

export default function Login() {
  const navigate = useNavigate();
  const { setUserId, setClinicId } = useAuthContext();

  const formik = useFormik({
    initialValues: {
      username: "",
      password: "",
    },
    onSubmit: (values) => {
      fetchPost("login", values).then((res) => {
        setUserId(res.id);
        setClinicId(res.clinics_id.id);
        localStorage.setItem("userId", res.id);
        localStorage.setItem("clinicId", res.clinics_id.id);
        navigate(`/schedule/${res.clinics_id.id}`);
      });
    },
  });

  return (
    <div className="flex h-screen p-8 bg-green-500 gap-5 items-center justify-center">
      <div className="bg-white w-5/12 p-6 rounded-md">
        <div className="flex flex-1 flex-col h-full items-center justify-center gap-8">
          <img
            src="src\assets\logotipo.png"
            style={{
              width: 200,
              height: 100,
              objectFit: "cover",
              borderRadius: 50,
            }}
          />
          <form className="flex flex-col gap-4">
            <InputComponent
              label="Login"
              id="username"
              name="username"
              onChange={formik.handleChange}
              values={formik.values.username}
            />
            <InputComponent
              label="Senha"
              id="password"
              name="password"
              onChange={formik.handleChange}
              values={formik.values.password}
            />
            <div className="w-full flex flex-1 items-center justify-center gap-8">
              <SimpleButton
                label="Entrar"
                type="submit"
                onClick={formik.handleSubmit}
              />
              <SimpleButton
                label="Cadastrar"
                type="button"
                onClick={() => navigate("/sign-up")}
              />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
