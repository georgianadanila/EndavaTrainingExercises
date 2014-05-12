select a.Departament_idDepartament, b.denumiredepartament, c.Salariu_maxim
from salariat a,departament b, (select max(salariu) Salariu_maxim, Departament_idDepartament dept from salariat group by Departament_idDepartament) c
where b.idDepartament=a.Departament_idDepartament and a.Departament_idDepartament=c.dept
group by a.Departament_idDepartament;
