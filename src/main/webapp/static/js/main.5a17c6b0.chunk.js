(this.webpackJsonprancoapp=this.webpackJsonprancoapp||[]).push([[0],{18:function(e,t,c){},30:function(e,t,c){},31:function(e,t,c){},34:function(e,t,c){},35:function(e,t,c){},41:function(e,t,c){},42:function(e,t,c){},43:function(e,t,c){"use strict";c.r(t);var a=c(1),s=c.n(a),n=c(10),i=c.n(n),r=(c(30),c(31),c(13)),o=c(2),l=c(3),j=c.n(l),d=c(6),b=c(7),h=c(0),x=function(e){var t=e.match;Object(a.useEffect)((function(){r(t.params.id)}),[]);var c=Object(a.useState)({}),s=Object(b.a)(c,2),n=s[0],i=s[1],r=function(e){fetch("http://localhost:5000/api/eventos/".concat(e)).then(function(){var e=Object(d.a)(j.a.mark((function e(t){var c,a;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.json();case 2:if(c=e.sent,t.ok){e.next=6;break}return a=c&&c.message||t.statusText,e.abrupt("return",Promise.reject(a));case 6:i(c);case 7:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())};return Object(h.jsxs)("div",{className:"listaEvento",children:[Object(h.jsxs)("div",{className:"header",children:[Object(h.jsx)("h1",{children:n.titulo}),Object(h.jsx)("div",{className:"blocoEvento",name:"status",id:"status",children:Object(h.jsx)("p",{children:function(e){try{document.getElementById("status").style.background=0==e?"red":"green"}catch(t){console.log(t)}}(n.status)})})]}),Object(h.jsxs)("div",{className:"colunas",children:[Object(h.jsxs)("div",{className:"coluna1",children:[Object(h.jsxs)("div",{className:"blocoEvento",name:"descricao",id:"descricao",children:[Object(h.jsx)("h3",{children:" Descri\xe7\xe3o"}),Object(h.jsx)("p",{children:n.descricao})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"sentimentos",children:[Object(h.jsx)("h3",{children:"Sentimentos"}),Object(h.jsx)("a",{href:"/adicionarSentimento",children:"Adicionar sentimento"})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"pontosDeMelhoria",children:[Object(h.jsx)("h3",{children:"Pontos de melhoria"}),Object(h.jsx)("p",{children:n.pontosDeMelhoria})]})]}),Object(h.jsx)("div",{className:"coluna2",children:Object(h.jsxs)("div",{id:"detalhes",children:[Object(h.jsxs)("div",{className:"blocoEvento",name:"categoria",children:[Object(h.jsx)("h3",{children:" Categoria"}),Object(h.jsx)("p",{children:n.categoria})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"motivo",children:[Object(h.jsx)("h3",{children:" Motivo"}),Object(h.jsx)("p",{children:n.motivo})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"data",children:[Object(h.jsx)("h3",{children:" Data"}),Object(h.jsx)("p",{children:n.data})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"expectativa",children:[Object(h.jsx)("h3",{children:" Expectativa"}),Object(h.jsx)("p",{children:n.expectativa})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"local",children:[Object(h.jsx)("h3",{children:" local"}),Object(h.jsx)("p",{children:n.local})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"pessoasEnvolvidas",children:[Object(h.jsx)("h3",{children:"Pessoas envolvidas"}),Object(h.jsx)("p",{children:n.pessoasEnvolvidas})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"feedback",children:[Object(h.jsx)("h3",{children:" feedback"}),Object(h.jsx)("p",{children:n.feedback})]})]})})]})]})},O=c(20),u=c(21),m=c(25),v=c(24),p=(c(34),function(e){Object(m.a)(c,e);var t=Object(v.a)(c);function c(){return Object(O.a)(this,c),t.apply(this,arguments)}return Object(u.a)(c,[{key:"render",value:function(){return Object(h.jsx)("div",{className:"container",children:Object(h.jsxs)("div",{className:"container_cadastro",children:[Object(h.jsxs)("div",{className:"conteudo",children:[Object(h.jsxs)("form",{className:"formulario",children:[Object(h.jsx)("h1",{children:"Cadastro"}),Object(h.jsx)("label",{className:"label",children:"Email"}),Object(h.jsx)("input",{type:"email",name:"email",id:"Email",placeholder:"escreva seu email"}),Object(h.jsx)("label",{className:"label",children:"Senha"}),Object(h.jsx)("input",{type:"password",name:"password",id:"Password",placeholder:"escreva sua senha"}),Object(h.jsxs)("div",{children:[Object(h.jsx)("legend",{className:"texto",children:"Tipo de Usuario"}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{id:"opcoes",type:"radio",name:"tipo"})," ","Psicologo"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{id:"opcoes",type:"radio",name:"tipo"})," ","Paciente"]})})]})]}),Object(h.jsxs)("div",{className:"descricao",children:[Object(h.jsx)("p",{className:"texto",children:"Tipo de Usuario"}),Object(h.jsx)("p",{children:"Descri\xe7\xe3o"})]})]}),Object(h.jsxs)("div",{className:"botoes",children:[Object(h.jsx)("button",{className:"botao",children:" Cadastrar "})," ",Object(h.jsx)("a",{href:"/login",className:"botao",children:" Login "})," "]})]})})}}]),c}(s.a.Component)),f=(c(35),"http://localhost:5000/api/login");function N(e,t){return g.apply(this,arguments)}function g(){return(g=Object(d.a)(j.a.mark((function e(t,c){var a,s,n;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return a={method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(c)},e.prev=1,t({type:"REQUEST_LOGIN"}),e.next=5,fetch("".concat(f,"/login"),a);case 5:return s=e.sent,e.next=8,s.json();case 8:if(!(n=e.sent)){e.next=13;break}return t({type:"LOGIN_SUCCESS",payload:n}),localStorage.setItem("currentUser",JSON.stringify(n)),e.abrupt("return",n);case 13:return t({type:"LOGIN_ERROR",error:n}),e.abrupt("return");case 17:e.prev=17,e.t0=e.catch(1),t({type:"LOGIN_ERROR",error:e.t0});case 20:case"end":return e.stop()}}),e,null,[[1,17]])})))).apply(this,arguments)}var E=c(11),y={userDetails:localStorage.getItem("currentUser"),loading:!1,errorMessage:null},w=function(e,t){switch(t.type){case"REQUEST_LOGIN":return Object(E.a)(Object(E.a)({},e),{},{loading:!0});case"LOGIN_SUCCESS":return Object(E.a)(Object(E.a)({},e),{},{user:t.payload,loading:!1});case"LOGOUT":return Object(E.a)(Object(E.a)({},e),{},{user:"",token:""});case"LOGIN_ERROR":return Object(E.a)(Object(E.a)({},e),{},{loading:!1,errorMessage:t.error});default:throw new Error("Unhandled action type: ".concat(t.type))}},S=s.a.createContext(),P=s.a.createContext();var k=function(e){var t=e.children,c=Object(a.useReducer)(w,y),s=Object(b.a)(c,2),n=s[0],i=s[1];return Object(h.jsx)(S.Provider,{value:n,children:Object(h.jsx)(P.Provider,{value:i,children:t})})};var C=function(){var e=Object(a.useState)(""),t=Object(b.a)(e,2),c=t[0],n=t[1],i=Object(a.useState)(""),r=Object(b.a)(i,2),o=r[0],l=r[1],x=function(){var e=s.a.useContext(P);if(void 0===e)throw new Error("useAuthDispatch must be used within a AuthProvider");return e}(),O=function(){var e=s.a.useContext(S);if(void 0===e)throw new Error("useAuthState must be used within a AuthProvider");return e}(),u=O.loading,m=(O.errorMessage,function(){var e=Object(d.a)(j.a.mark((function e(t){var a;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),a={email:c,password:o},e.prev=2,e.next=5,N(x,a);case 5:if(e.sent){e.next=8;break}return e.abrupt("return");case 8:window.location.href="/",e.next=14;break;case 11:e.prev=11,e.t0=e.catch(2),console.log(e.t0);case 14:case"end":return e.stop()}}),e,null,[[2,11]])})));return function(t){return e.apply(this,arguments)}}());return Object(h.jsx)("div",{className:"container",children:Object(h.jsx)("div",{className:"container_login",children:Object(h.jsxs)("form",{className:"formulario",onSubmit:m,children:[Object(h.jsxs)("div",{children:[Object(h.jsx)("legend",{className:"titulo",children:"login"}),Object(h.jsx)("label",{className:"label",children:"Email"}),Object(h.jsx)("input",{type:"email",name:"email",id:"Email",placeholder:"escreva seu email",required:!0,value:c,onChange:function(e){return n(e.target.value)}})]}),Object(h.jsxs)("div",{children:[Object(h.jsx)("label",{className:"label",children:"Senha"}),Object(h.jsx)("input",{type:"password",name:"password",id:"Password",placeholder:"escreva sua senha",required:!0,value:o,onChange:function(e){return l(e.target.value)}})]}),u?Object(h.jsx)("p",{children:"Carregando .."}):Object(h.jsx)("button",{children:" Login "})]})})})},M=function(e){return Object(h.jsx)("nav",{className:"navbar",children:Object(h.jsxs)("div",{className:"navegacao",children:[Object(h.jsxs)("div",{className:"navbar-header",children:[Object(h.jsx)("a",{className:"tittle",href:"/",children:"Invocado"})," "]}),Object(h.jsxs)("div",{className:"paginas",children:[Object(h.jsx)("li",{children:Object(h.jsx)("a",{href:"/eventos",className:"page",children:"Eventos"})}),Object(h.jsx)("li",{children:Object(h.jsx)("a",{href:"/medicacoes",className:"page",children:"Medica\xe7\xf5es"})}),Object(h.jsx)("li",{children:Object(h.jsx)("a",{href:"/cadastrarmedicacoes",className:"page",children:"Novas Medica\xe7\xf5es"})}),Object(h.jsx)("li",{children:Object(h.jsx)("a",{href:"/cadastro",className:"page",children:"Cadastro"})}),Object(h.jsx)("li",{children:Object(h.jsx)("a",{href:"/perfil",className:"page",children:"Perfil"})})]})]})})},D=(c(18),function(){Object(a.useEffect)((function(){n()}),[]);var e=Object(a.useState)([]),t=Object(b.a)(e,2),c=t[0],s=t[1],n=function(){fetch("http://localhost:5000/api/eventos").then(function(){var e=Object(d.a)(j.a.mark((function e(t){var c,a;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.json();case 2:if(c=e.sent,t.ok){e.next=6;break}return a=c&&c.message||t.statusText,e.abrupt("return",Promise.reject(a));case 6:console.log(c),s(c);case 8:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())};return Object(h.jsx)("div",{children:Object(h.jsxs)("div",{className:"listaEvento",children:[Object(h.jsx)("h1",{id:"eventos",children:"Meus Eventos"}),Object(h.jsx)("a",{href:"/adicionarEvento",children:"Adicionar Evento"}),c.map((function(e){return Object(h.jsx)(r.b,{to:"/eventos/".concat(e.id),children:Object(h.jsxs)("div",{className:"blocoEvento",children:[Object(h.jsx)("h3",{children:e.titulo}),Object(h.jsxs)("h3",{children:["Categoria : ",e.categoria]})]})},e.id)}))]})})}),T=function(){Object(a.useEffect)((function(){n()}),[]);var e=Object(a.useState)([]),t=Object(b.a)(e,2),c=t[0],s=t[1],n=function(){fetch("http://localhost:5000/api/medicacoes").then(function(){var e=Object(d.a)(j.a.mark((function e(t){var c,a;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.json();case 2:if(c=e.sent,t.ok){e.next=6;break}return a=c&&c.message||t.statusText,e.abrupt("return",Promise.reject(a));case 6:console.log(c),s(c);case 8:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())};return Object(h.jsxs)("div",{className:"listaEvento",children:[Object(h.jsx)("h1",{id:"medicacao",children:"Minhas Medica\xe7\xf5es"}),Object(h.jsx)("div",{children:Object(h.jsx)("a",{href:"/medicacoes/${medicacao.id}",children:"Visualizar Medica\xe7\xf5es"})}),Object(h.jsx)("div",{children:Object(h.jsx)("a",{href:"/cadastrarmedicacoes",children:"Adicionar Medica\xe7\xf5es"})}),c.map((function(e){return Object(h.jsx)(r.b,{to:"/medicacoes/".concat(e.id),children:Object(h.jsxs)("div",{className:"blocoEvento",children:[Object(h.jsx)("h3",{children:e.nome}),Object(h.jsxs)("h3",{children:["Posologia: ",e.posologia]})]})},e.id)}))]})},I=function(e){var t=e.match;Object(a.useEffect)((function(){r(t.params.id)}),[]);var c=Object(a.useState)({}),s=Object(b.a)(c,2),n=s[0],i=s[1],r=function(e){fetch("http://localhost:5000/api/medicacoes/".concat(e)).then(function(){var e=Object(d.a)(j.a.mark((function e(t){var c,a;return j.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.json();case 2:if(c=e.sent,t.ok){e.next=6;break}return a=c&&c.message||t.statusText,e.abrupt("return",Promise.reject(a));case 6:i(c);case 7:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())};return Object(h.jsxs)("div",{className:"listaMedicamento",children:[Object(h.jsx)("div",{className:"inicio",children:Object(h.jsx)("h1",{children:n.nome})}),Object(h.jsxs)("div",{className:"primeiraColuna",children:[Object(h.jsxs)("div",{className:"blocoMedicamento",name:"descricao",id:"descricao",children:[Object(h.jsx)("h3",{children:"Descricao"}),Object(h.jsx)("p",{children:n.descricao})]}),Object(h.jsxs)("div",{className:"blocoMedicamento",name:"observacao",id:"observacao",children:[Object(h.jsx)("h3",{children:"Observa\xe7\xe3o"}),Object(h.jsx)("p",{children:n.observacao})]})]}),Object(h.jsxs)("div",{className:"segundaColuna",children:[Object(h.jsxs)("div",{className:"blocoMedicamento",name:"intervalo",id:"intervalo",children:[Object(h.jsx)("h3",{children:"Intervalo"}),Object(h.jsx)("p",{children:n.intervalo})]}),Object(h.jsxs)("div",{className:"blocoMedicamento",name:"ultimaDosagem",id:"ultimaDosagem",children:[Object(h.jsx)("h3",{children:"\xdaltima Dosagem"}),Object(h.jsx)("p",{children:n.ultimaDosagem})]}),Object(h.jsxs)("div",{className:"blocoMedicamento",name:"posologia",id:"posologia",children:[Object(h.jsx)("h3",{children:" Posologia"}),Object(h.jsx)("p",{children:n.posologia})]})]})]})},L=(c(41),c(42),function(e){e.match;return Object(h.jsxs)("div",{className:"listaEvento",children:[Object(h.jsxs)("div",{className:"header",children:[Object(h.jsx)("textarea",{rows:"1",cols:"80",id:"titulo",placeholder:"Titulo"}),Object(h.jsx)("div",{className:"blocoEvento",name:"status",id:"status",children:Object(h.jsx)("p",{children:"status"})})]}),Object(h.jsxs)("div",{className:"colunas",children:[Object(h.jsxs)("div",{className:"coluna1",children:[Object(h.jsx)("div",{className:"blocoEvento",name:"descricao",id:"descricao",children:Object(h.jsx)("textarea",{rows:"21",cols:"80",id:"novoProjeto",placeholder:"descri\xe7\xe3o"})}),Object(h.jsxs)("div",{className:"blocoEvento",name:"sentimentos",children:[Object(h.jsx)("h3",{children:" Sentimentos"}),Object(h.jsx)("a",{href:"/adicionarSentimento",children:"Adicionar sentimento"})]}),Object(h.jsx)("div",{className:"blocoEvento",name:"pontosDeMelhoria",children:Object(h.jsx)("textarea",{rows:"3",cols:"80",id:"novoProjeto",placeholder:"Pontos de melhoria"})}),Object(h.jsx)("div",{className:"blocoEvento",name:"expectativa",children:Object(h.jsx)("textarea",{rows:"3",cols:"80",id:"novoProjeto",placeholder:"Expectativa"})}),Object(h.jsx)("div",{className:"blocoEvento",name:"feedback",children:Object(h.jsx)("textarea",{rows:"3",cols:"80",id:"novoProjeto",placeholder:"Feedback"})})]}),Object(h.jsx)("div",{className:"coluna2",children:Object(h.jsxs)("div",{id:"detalhes",children:[Object(h.jsxs)("div",{className:"blocoEvento",name:"categoria",children:[Object(h.jsx)("h3",{children:" Categoria"}),Object(h.jsxs)("div",{tag:"fieldset",children:[Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Amigos"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Desconhecidos"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Escola"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Faculdade"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Familia"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Trabalho"]})})]})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"motivo",children:[Object(h.jsx)("h3",{children:" Motivo"}),Object(h.jsxs)("div",{tag:"fieldset",children:[Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Culpa"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Medo"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Timidez"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Tristeza"]})}),Object(h.jsx)("div",{children:Object(h.jsxs)("label",{className:"texto",children:[Object(h.jsx)("input",{type:"radio",name:"tipo"})," ","Vergonha"]})})]})]}),Object(h.jsxs)("div",{className:"blocoEvento",name:"data",children:[Object(h.jsx)("h3",{children:" Data"}),Object(h.jsx)("input",{type:"date",id:"data",name:"data",placeholder:"Data"})]}),Object(h.jsx)("div",{className:"blocoEvento",name:"local",children:Object(h.jsx)("textarea",{rows:"1",cols:"20",id:"novoProjeto",placeholder:"Local"})}),Object(h.jsx)("div",{className:"blocoEvento",name:"pessoasEnvolvidas",children:Object(h.jsx)("textarea",{rows:"3",cols:"20",id:"novoProjeto",placeholder:"Pessoas Envolvidas"})}),Object(h.jsx)("a",{className:"botao",id:"salvar",children:"Salvar"})]})})]})]})});var R=function(){return Object(h.jsx)(k,{children:Object(h.jsx)(r.a,{children:Object(h.jsxs)("div",{children:[Object(h.jsx)(M,{}),Object(h.jsxs)(o.c,{children:[Object(h.jsx)(o.a,{path:"/cadastro",exact:!0,component:p}),Object(h.jsx)(o.a,{path:"/login",exact:!0,component:C}),Object(h.jsx)(o.a,{path:"/eventos",exact:!0,component:D}),Object(h.jsx)(o.a,{path:"/eventos/:id",component:x}),Object(h.jsx)(o.a,{path:"/medicacoes",exact:!0,component:T}),Object(h.jsx)(o.a,{path:"/medicacoes/:id",component:I}),Object(h.jsx)(o.a,{path:"/adicionarEvento",component:L})]})]})})})},U=function(e){e&&e instanceof Function&&c.e(3).then(c.bind(null,44)).then((function(t){var c=t.getCLS,a=t.getFID,s=t.getFCP,n=t.getLCP,i=t.getTTFB;c(e),a(e),s(e),n(e),i(e)}))};i.a.render(Object(h.jsx)(s.a.StrictMode,{children:Object(h.jsx)(R,{})}),document.getElementById("root")),U()}},[[43,1,2]]]);
//# sourceMappingURL=main.5a17c6b0.chunk.js.map