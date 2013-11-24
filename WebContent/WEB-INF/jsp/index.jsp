<h1>Accueil</h1>

<div>
	<h2>Comment est organis� le projet ?</h2>
	<span>Hi�rarchie :</span>
	<ul>
		<li>
			src
			<ul>	
				<li>Controller.java</li>
				<li>Toolbox.java</li>
			</ul>
		</li>
		<li>
			WebContent
			<ul>
				<li>META-INF</li>
				<li>
					WEB-INF
					<ul>
						<li>css</li>
						<li>jsp</li>
						<li>lib</li>
						<li>main.jsp</li>
						<li>web.xml</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
	<h2>Comment fonctionne le projet ?</h2>
	<p>Le projet est g�r� par le <strong>Controller</strong> (servlet.Controller.java) qui g�re l'appelle des pages.</p>
	<p>Ce dernier appelle la template principale (WEB-INF/jsp/main.jsp) ainsi que l'autre template de type "content" (le contenu variant de la page, le corps)</p>
	<p>La template "content" est connue gr�ce au param�tre "page" pass� dans l'URL (m�thode GET) ou en POST</p>
	<p>Pour le css, le <strong>Controller</strong> r�cup�re le contenu du fichier de css principal (WEB-INF/css/main.css) ainsi que le fichier css sp�cifique dans le m�me dossier (exemple: WEB-INF/css/index.css, pour cette page)</p>
	<p>La classe <strong>Toolbox</strong> est un ensemble de fonctions utiles pour l'application.</p>
</div>