# APi Rest de Gestão de Academia

API REST em Spring Boot 3 para gerenciar **alunos**, **planos**, **treinos**, **pagamentos** e os **vínculos aluno–treino**.

---

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)
- Maven

---

## Estrutura do Projeto

**Pacote base:** `com.example.SenaiWagner.gestaoAcademia`  
Arquitetura em camadas por domínio funcional.

### Controller
- **AlunoController** — endpoints de CRUD de alunos e ativação/inativação.
- **PlanoController** — endpoints de CRUD de planos.
- **TreinoController** — endpoints de CRUD e atualização de treinos.
- **PagamentoController** — endpoints de criação e listagem de pagamentos.
- **AlunoTreinoVinculoController** — endpoints para vincular/desvincular aluno e treino.

### Service
- **AlunoService** — regras de aluno (status, vínculo a plano).
- **PlanoService** — regras de plano (nome, valor mensal).
- **TreinoService** — regras de treino (nome, descrição, nível).
- **PagamentoService** — regras de pagamento (forma, status, valor).
- **AlunoTreinoVinculoService** — regras de associação aluno–treino.

### Repository
- **AlunoRepository** — `JpaRepository` para `Aluno`.
- **PlanoRepository** — `JpaRepository` para `Plano`.
- **TreinoRepository** — `JpaRepository` para `Treino`.
- **PagamentoRepository** — `JpaRepository` para `Pagamento`.
- **AlunoTreinoVinculoRepository** — `JpaRepository` para `AlunoTreinoVinculo`.

### DTO
- **AlunoDTO** — dados de entrada/saída de aluno.
- **PlanoDTO** — dados de plano.
- **TreinoDTO** — dados de treino.
- **PagamentoDTO** — dados de pagamento.
- **AlunoTreinoVinculoDTO** — dados de vínculo aluno–treino.

### Entity
- **Aluno** — entidade de aluno (status e plano).
- **Plano** — entidade de plano (nome e valor).
- **Treino** — entidade de treino (descrição e nível).
- **Pagamento** — entidade de pagamento (forma, status, valor).
- **AlunoTreinoVinculo** — entidade de associação aluno–treino.

---

## Instruções para Rodar o Projeto
1. Clone o repositório.  
2. Entre no diretório do projeto.  
3. Instale as dependências e compile.  
4. Execute a aplicação.  
   - Ou rode pela IDE em **Run → GestaoAcademiaApplication**.

**Banco de Dados:** H2 em modo arquivo, criado automaticamente em `./data`.  
**Swagger UI:** `http://localhost:8080/swagger-ui.html`

---

## Descrição da Solução
- **Alunos:** cadastro, status ativo/inativo, vínculo a plano.  
- **Planos:** nome e valor mensal.  
- **Treinos:** nome, descrição e nível de dificuldade.  
- **Pagamentos:** forma de pagamento, status e valor.  
- **Associação Aluno–Treino:** registro de quais alunos estão em quais treinos.

---

## Endpoints Testados (descrições)
- **Criar Plano**
  <img width="1490" height="623" alt="CriarPlano" src="https://github.com/user-attachments/assets/60daec0f-c7ea-4a91-aa2a-76d1f1dd42b8" />
  
- **Criar Aluno**
   <img width="1418" height="705" alt="CriarAluno" src="https://github.com/user-attachments/assets/b903622b-4bec-45ef-9158-adadc2b7f4c6" />
   
- **Criar Treino**
  <img width="1425" height="630" alt="CriarTreino" src="https://github.com/user-attachments/assets/a4b826ff-bf24-4a3c-9415-4c535eaccae8" />
  
- **Vincular Aluno e Treino**
<img width="1420" height="579" alt="VincularAlunoTreino" src="https://github.com/user-attachments/assets/42c133ac-fe86-4d75-b081-e8f6f5b0af46" />

- **Deletar Aluno**
<img width="1411" height="404" alt="DeletandoAluno" src="https://github.com/user-attachments/assets/d1e653f0-f4bd-431b-9a17-16d09710a47d" />

---
