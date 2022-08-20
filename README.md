#  [ToDO-APP 📝](#todo-app-)
## Anote tudo, não esqueça de nada.
<br>
<br>


  - [📃Descrição](#descrição)
  - [🔧 Funcionalidades](#-funcionalidades)
  - [✔️ Técnicas e tecnologias utilizadas](#️-técnicas-e-tecnologias-utilizadas)
  - [🧩 Dependências](#-dependências)
    - [💻 JVM](#-jvm)
    - [⚙️ Maven (Opcional)](#-⚙️-Maven-(Opcional))
  - [📦 Executando o projeto](#-executando-o-projeto)
  - [📓 Criação de projeto](#-criação-de-projeto)
  - [📓👀 Visualização de projeto](#-visualização-de-projeto)
  - [📓✏️ Edição de projeto](#️-edição-de-projeto)
  - [📓❌ Exclusão de projeto](#-exclusão-de-projeto)
  - [📜 Criação de tarefa](#-criação-de-tarefa)
    - [📄 Tarefa com prazo não expirado](#-tarefa-com-prazo-não-expirado)
    - [📄 Tarefa com prazo expirado](#-tarefa-com-prazo-expirado)
    - [📄 Tarefa que o prazo expira no dia atual](#-tarefa-que-o-prazo-expira-no-dia-atual)
    - [📄 Tarefa marcada como concluída](#-tarefa-marcada-como-concluída)
  - [📄 Filtros de tarefas](#-filtros-de-tarefas)
  - [📝 Edição de tarefa](#-edição-de-tarefa)
  - [📄👀 Visualização de tarefa](#-visualização-de-tarefa)
  - [📄❌ Exclusão de tarefa](#-exclusão-de-tarefa)
  - [⏰ Demostração alarme de tarefa expirada](#-demostração-alarme-de-tarefa-expirada)
  - [🙈 Esconder janela do ToDo-APP](#-esconder-janela-do-todo-app)
<br>

## 📃Descrição
Programa para organizar tarefas e projetos.
Organize tarefas por projeto, defina um prazo para cada tarefa e torne seu dia mais produtivo com o ToDo-APP.
<br>


## 🔧 Funcionalidades
- Criação projeto
- Visualizar projeto
- Edição projeto
- Exclusão projeto
- Criação tarefa
- Marcar tarefa como concluída
- Filtros de tarefas
- Edição tarefa
- Visualizar tarefa
- Ligar alarmes
- System tray
<br>



## ✔️ Técnicas e tecnologias utilizadas
- Java 17
- Maven 3.8.6
- Swing-UI
- SQLite
- jdatepicker

## 🧩 Dependências
### 💻 JVM
Para executar a ferramenta é necessário ter instalado no sistema operacional a máquina virtual do Java na versão 17 ou superior. Link para download: https://www.oracle.com/java/technologies/downloads/


### ⚙️ Maven (Opcional)
Caso deseje compilar o projeto é necessário ter instalado o Maven na versão 3.8.6 ou superior. Link para download: https://maven.apache.org/download.cgi

Manual de instalação no windows com adição de variável de ambiente: http://charlesmms.azurewebsites.net/2017/09/04/instalando-maven-no-windows-10/

## 📦 Executando o projeto
- Primeira forma: Baixando o arquivo jar
```bash
Baixe a versão release do projeto no link abaixo:

# Windows
Pode ser executado clicando no arquivo TodoApp.jar

# Linux
Pode ser executado usando o terminal e executando o comando:
jar -jar TodoApp.jar
```
- Segunda forma: Compilando o projeto
```bash
1° Faça o download ou clone do repositório do projeto.
2° Abra o terminal no diretório do projeto.
3° Execute o comando:  mvn compile assembly:single

Seu arquivo jar será gerado na pasta target.
```

##
## 📓 Criação de projeto
![Create Project](assets/1-%20Criação%20Projeto.gif)
<br>
<br>

## 📓👀 Visualização de projeto
![View Project](assets/2-%20Visualiza%C3%A7%C3%A3o%20Projeto.gif)
<br>
<br>

## 📓✏️ Edição de projeto
![Edit Project](assets/3-%20Edi%C3%A7%C3%A3o%20Projeto.gif)
<br>
<br>

## 📓❌ Exclusão de projeto
![Remove Project](assets/4-%20Remo%C3%A7%C3%A3o%20Projeto.gif)
<br>
<br>

## 📜 Criação de tarefa
### 📄 Tarefa com prazo não expirado
![Crete Task](assets/5-%20Nova%20Tarefa.gif)
<br>
<br>

### 📄 Tarefa com prazo expirado
![Expired Task](assets/6-%20Tarefa%20Expirada.gif)
<br>
<br>

### 📄 Tarefa que o prazo expira no dia atual
![Expire on day Task](assets/7-%20Tarefa%20que%20expira%20no%20dia%20atual.gif)
<br>
<br>

### 📄 Tarefa marcada como concluída
![Completed Task](assets/8-%20Tarefa%20Conclu%C3%ADda.gif)
<br>
<br>

## 📄 Filtros de tarefas
![Filter Task](assets/9-%20Filtros.gif)
<br>
<br>

## 📝 Edição de tarefa
![Edit Task](assets/10-%20Edição%20Tarefa.gif)
<br>
<br>

## 📄👀 Visualização de tarefa
![View Task](assets/11-%20Visualiza%C3%A7%C3%A3o%20detalhes%20tarefa.gif)
<br>
<br>

## 📄❌ Exclusão de tarefa
![View Task](assets/14-Exclus%C3%A3o%20Tarefa.gif)
<br>
<br>

## ⏰ Demostração alarme de tarefa expirada
![Alarm](assets/12-%20Alarme.gif)

## 🙈 Esconder janela do ToDo-APP
![System Tray](assets/13-%20Minimize%20to%20tray.gif)