# Vollmed API

# Descrição
- A Vollmed API é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Ela fornece uma solução para gerenciar médicos, pacientes e consultas médicas. A aplicação inclui funcionalidades de autenticação e autorização com JWT, gerenciamento de entidades (CRUD) e persistência de dados em um banco de dados MySQL.

# Estrutura do Projeto
- Pacotes Principais
- medd.voll.api.consulta: Contém a lógica relacionada às consultas médicas.
- medd.voll.api.controller: Contém os controladores responsáveis pelas requisições HTTP.
- medd.voll.api.domain.endereco: Contém classes e registros relacionados aos endereços.
- medd.voll.api.domain.medico: Contém classes e registros relacionados aos médicos.
- medd.voll.api.domain.paciente: Contém classes e registros relacionados aos pacientes.
- medd.voll.api.domain.usuario: Contém classes e registros relacionados aos usuários e autenticação.
- medd.voll.api.infra.exception: Contém tratadores de exceções globais.
- medd.voll.api.infra.security: Contém a configuração de segurança e serviços relacionados a tokens JWT.
  
  ![1](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/ce0747d1-c5ed-462a-84b3-5c0be87722f7)

# Configuração

# Banco de Dados
- A aplicação utiliza MySQL como banco de dados. As configurações de conexão estão no arquivo application.properties.

- Scripts SQL
- Criação de tabelas:
  
  ![2](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/e070edda-f70a-40ce-9657-f0e79113a457)

# Funcionalidades
# Autenticação
- A autenticação é gerenciada pelo pacote medd.voll.api.consulta com o controlador AutenticacaoController. Este controlador utiliza um AuthenticationManager e TokenService para autenticar usuários e gerar tokens JWT.

  ![3](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/599a3683-5e5c-4990-a6fd-be0ea5fbf38b)


# Gerenciamento de Médicos
- O pacote medd.voll.api.domain.medico e o controlador MedicoController oferecem endpoints para CRUD de médicos:

  ![4](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/9001f7b9-a34e-4504-90d3-c10be25d568f)



- POST /medicos: Cadastrar um novo médico.
- GET /medicos: Listar médicos ativos.
- PUT /medicos: Atualizar informações de um médico.
- DELETE /medicos/{id}: Desativar um médico.
- GET /medicos/{id}: Detalhar um médico específico.


# Gerenciamento de Pacientes
- O pacote medd.voll.api.domain.paciente e um controlador correspondente oferecem endpoints para CRUD de pacientes:


- POST /pacientes: Cadastrar um novo paciente.
- GET /pacientes: Listar pacientes ativos.
- PUT /pacientes: Atualizar informações de um paciente.
- DELETE /pacientes/{id}: Desativar um paciente.
- GET /pacientes/{id}: Detalhar um paciente específico.

  ![5](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/659eca60-69ea-4089-9974-5d452d4e1afe)

# Autenticação e Autorização:
- Após a autenticação bem-sucedida, é gerado um token de acesso usando a classe TokenService, que utiliza o padrão JWT (JSON Web Token).
- O token JWT contém informações sobre o usuário autenticado e é utilizado para autorizar o acesso a recursos protegidos da API.
- Proteção de Endpoints:

  ![9](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/d0f5f06b-ad1a-41a8-af5e-e555c913b93a)
  
- Alguns endpoints da API estão protegidos e exigem autenticação para serem acessados. Por exemplo, o endpoint para agendar consultas (/consultas) está protegido e requer um token JWT válido para acesso.
- A anotação @PreAuthorize ou configurações no Spring Security podem ser utilizadas para definir as permissões necessárias para acessar determinados endpoints.

- O token JWT gerado pelo TokenService possui um tempo de expiração configurado para aumentar a segurança. Geralmente, o token JWT é válido por um período limitado de tempo (por exemplo, 2 horas).
- Após o tempo de expiração, o token JWT não é mais válido e o usuário precisa autenticar novamente para obter um novo token.
- Criptografia de Senhas:

  ![9](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/74f29b94-2de5-4b8d-88f4-3b2ed9b1412a) 

- O controle de acesso é implementado para garantir que apenas usuários autenticados e autorizados possam acessar recursos específicos da API.
- Isso pode incluir diferentes níveis de permissões para diferentes tipos de usuários (por exemplo, administradores, médicos, pacientes) para acessar e modificar dados na API.
- Token JWT e Expiração:

  ![10](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/735eb517-aa89-4ae1-b83f-0b06c6af31df)

  ![11](https://github.com/DEVsalaberry/voll-medd-api/assets/160683550/bb5a4713-31d5-4e35-ba61-0b7089b231b1)
  
- As senhas dos usuários são armazenadas de forma segura utilizando técnicas de criptografia. O Spring Security geralmente utiliza o algoritmo BCrypt para criptografar e verificar senhas de forma segura.
- Tratamento de Exceções de Segurança:

- O projeto inclui um tratador de erros (TratadorDeErros) para lidar com exceções relacionadas à segurança, como autenticação falhada, autorização negada, entre outros.
- Essas exceções são tratadas de forma adequada e retornam respostas HTTP apropriadas para informar o cliente sobre o motivo da falha na segurança.

- Desenvolver este projeto do zero foi uma experiência enriquecedora e desafiadora. Através da criação de uma API Rest em Java com Spring Boot, implementando CRUDs, validações, paginação, segurança com Spring Security e JWT, além de seguir princípios SOLID
- pude aprimorar meu conhecimento em desenvolvimento de software. A padronização dos retornos, uso correto dos códigos HTTP
- documentação OpenAPI e testes automatizados foram aspectos essenciais para garantir a qualidade e confiabilidade da aplicação.
- Esta jornada ampliou minha compreensão sobre arquitetura de software e me preparou para enfrentar desafios mais complexos no futuro.
  
