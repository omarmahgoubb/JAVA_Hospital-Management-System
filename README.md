# 🏥 Hospital Management System (Java)

A simple, object‑oriented **Java** console application for managing **patients, doctors, and appointments**.  
Stores data **in memory**, showcases clean OOP (inheritance, interfaces, composition), and includes an interactive console UI and test drivers.

---

## ✨ Features

- **Patients**
  - Base model: `PatientBase` (ID, name, age, contact, medical notes, assigned doctor, category)
  - Specializations:
    - `SurgicalPatient` (surgery type/date, surgeon, cost calculation hook)
    - `PediatricPatient` (guardian contact, pediatric rules)
    - `Outpatient` (visit frequency, next appointment helpers)
  - Per‑type billing via `calculateTreatmentCost()`
- **Doctors & Appointments**
  - Create/list doctors (`Doctor`)
  - Schedule appointments (`Appointment`) with `java.time.LocalDate`
  - List appointments by doctor or patient
- **Categories & Treatments**
  - `PatientCategory` (classification & constraints)
  - `TreatmentData` (treatment id/type/base cost)
- **Interactive UI & Test Drivers**
  - `HospitalManagementUI` — menu‑driven console UI
  - `HospitalTester` & `PatientBaseTester` — sample scenarios
- **Core Manager & Interface**
  - `HospitalManagement` implements `HOSPITALInterface` and owns in‑memory collections

> Data is **not persisted** (clears on exit). You can add JSON/CSV/JDBC later.

---

## 🛠 Requirements

- **JDK 11+** (JDK 17 recommended)
- No external dependencies

---

## 🚀 Build & Run

Compile all sources:

```bash
javac *.java
```

Run the interactive console UI:

```bash
java HospitalManagementUI
```

Run sample testers (optional):

```bash
java HospitalTester
java PatientBaseTester
```

> If you see `ClassNotFoundException`, ensure **all** `.java` files are in the same folder (or adjust packages/classpath accordingly).

---

## 📁 Files Included

- `Appointment.java`
- `Doctor.java`
- `HOSPITALInterface.java`
- `HospitalManagement.java`
- `HospitalManagementUI.java`
- `HospitalTester.java`
- `Outpatient.java`
- `PatientBase.java`
- `PatientBaseTester.java`
- `PatientCategory.java`
- `PediatricPatient.java`
- `SurgicalPatient.java`
- `TreatmentData.java`

---

## 🔎 Notes

- Dates use `java.time.LocalDate` (e.g., `LocalDate.of(2025, 8, 30)`).
- Console menus guide common operations: add patients/doctors, assign doctors, schedule/list appointments, and compute costs.
- Consider adding input validation and persistence for production use.
